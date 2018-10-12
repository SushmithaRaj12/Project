package com.sush.dao;

import com.sush.model.Cart;
import com.sush.model.CartItem;
import com.sush.model.CustomerOrder;

public interface CartItemDao
{
void saveOrUpdateCartItem(CartItem cartItem);
	
	void removeCartItem(int cartItemId);
	
	Cart getCart(int cartId);
	
	CustomerOrder createOrder(Cart cart);
}
