package com.kh.jaManChw.payment.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Payment;
import com.kh.jaManChw.dto.ShoppingBasket;

public interface PaymentDao {

	public void insertPayment(Payment payment);
	
	public List<ShoppingBasket> selectShoppingBasketList(List<ShoppingBasket> sbList);

	public Map<String, Object> selectShoppingAllBasketList(int basketno);

	/**
	 * 한번 결제 시도로 같이 결제되는 결제 목록을 묶어주는 oncetrypayno를 반환한다
	 * 
	 * @return oncetrypayno
	 */
	public int selectOncetrypayno();

	public void selectShoppingBasket(int i);

	public void insertShoppingBasketList(Map<String, Object> map);

	public void insertShoppingBasketBuyList(Map<String, Object> map);

	public void deleteShoppingBasketList(int i);

	public Object selectOptionByOptionno(Object object);

	public Map<String, String> selectUserInfo(String userno);

	public Object selectShoppingAllBasketList1(int i);

	
	

}
