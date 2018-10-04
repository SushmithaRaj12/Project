package com.sush.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sush.dao.CartDAO;
import com.sush.dao.OrderDAO;
import com.sush.model.CartItem;
import com.sush.model.OrderDetail;

@Controller
public class OrderController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/payment")
	public String showPaymentPage()
	{
		return "Payment";
	}
	
	@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
	public String paymentProcess(@RequestParam("pmode")String pmode,HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItems=cartDAO.retrieveCartItems(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalValue(listCartItems));
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentmode(pmode);
		orderDetail.setTotalShoppingAmount((int)this.calcGrandTotalValue(listCartItems));
		
		orderDAO.insertOrderDetail(orderDetail);
		
		System.out.println("OrderDetail have been saved");
		
		return "ThankYou";
	}
	
	public long calcGrandTotalValue(List<CartItem> listCartItems)
	{
		int count=0;
		long grandTotalPrice=0;
		while(count<listCartItems.size())
		{
			grandTotalPrice+=(listCartItems.get(count).getQuantity()*listCartItems.get(count).getPrice());
			count++;
		}
		
		return grandTotalPrice;
	}

	
	

}
