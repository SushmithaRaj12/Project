package com.sush.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sush.dao.CartDAO;
import com.sush.dao.CategoryDAO;
import com.sush.model.CartItem;
import com.sush.model.Category;

public class CartDAOTest {
	static CartDAO cartDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.sush");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("CartDAO");
	}

 //@Ignore
	@Test
	public void addCartItemTest() {
		CartItem cartItem = new CartItem();
		cartItem.setProductId(1);
		cartItem.setProductName("kylie blush");
		cartItem.setQuantity(5);
		cartItem.setPrice(1300);
		cartItem.setUsername("gigi");
		cartItem.setPstatus("Not Paid");
		assertTrue("Problem in adding the Cart Item:", cartDAO.addCartItem(cartItem));
	}

@Ignore
	@Test
	public void deleteCartItemTest() {
		CartItem cartItem = cartDAO.getCartItem(1);
		cartItem.setProductName("lipstick");
		assertTrue("Problem in deleting the Cart Item:", cartDAO.deleteCartItem(cartItem));
	}

@Ignore
	@Test
	public void updateCartItemTest() {
		CartItem cartItem = cartDAO.getCartItem(1);
		cartItem.setProductName("hudabeauty");
		cartItem.setPrice(780);
		assertTrue("Problem in updating the Cart Item:", cartDAO.updateCartItem(cartItem));
	}

@Ignore  
	@Test
	public void retrieveCartItemTest() {
		List<CartItem> listCartItems = cartDAO.retrieveCartItems("gigi");
		assertNotNull("Problem in retrieving the Cart Items", listCartItems.size() > 0);
		for (CartItem cartItem : listCartItems) {
			System.out.print(cartItem.getProductName() + ":::");
			System.out.print(cartItem.getQuantity() + ":::");
			System.out.print(cartItem.getProductId());
		}

	}

}
