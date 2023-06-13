package com.kh.jaManChw.payment.dao.face;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.kh.jaManChw.dto.Payment;
import com.kh.jaManChw.dto.ShoppingBasket;

public interface PaymentDao {

	public void insertPayment(Payment payment);
	
	public List<ShoppingBasket> selectShoppingBasketList(List<ShoppingBasket> sbList);

	public List<ShoppingBasket> selectShoppingAllBasketList(ShoppingBasket shoppingBasket);

	
	

}
