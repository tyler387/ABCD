package com.kh.jaManChw.payment.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.kh.jaManChw.dto.ShoppingBasket;

public interface PaymentService {


	/**
	 * 파라미터로 받은 배열을 DTO에 저장하기 
	 * 
	 * @param sbItemcount - 구매상품 수량
	 * @param basketno - 장바구니 번호
	 * @return 추출하여 완성된 리스트 DTO 
	 * 
	 */
	public List<Map<String, Object>> getParamList(int[] basketno);

	public JSONObject paymentInfo(HttpServletRequest request, Map<String, Object> map, int[] basketno, String[] itemTitle, HttpSession session);

	public Map<String, String> getuserinfo(String userno);


}
