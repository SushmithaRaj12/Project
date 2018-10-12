package com.sush.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sush.model.Cart;
import com.sush.model.CartItem;
import com.sush.model.Customer;
import com.sush.model.CustomerOrder;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void saveOrUpdateCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		
	}
	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.getCurrentSession();
	    
	    CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
	   
	    session.delete(cartItem);
		
	}
	public Cart getCart(int cartId) {

		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		
		return cart;
	}
	public CustomerOrder createOrder(Cart cart) {
		
		Session session=sessionFactory.getCurrentSession();
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		List<CartItem> cartItems=cart.getCartItems();
		double grandTotal=0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice() + grandTotal;
		}
		
		cart.setGrandTotal(grandTotal);//update grandtotal column in cart
		customerOrder.setCart(cart);//FK cart_id
		Customer customer=cart.getCustomer();
		customerOrder.setCustomer(customer);//FK customer_id
		customerOrder.setBillingAddress(customer.getBillingaddress());//FK billingaddress_id
		customerOrder.setShippingAddress(customer.getShippingaddress());//FK shipping Address Id
		session.save(customerOrder);
		
		return customerOrder;
	}
	
	
}