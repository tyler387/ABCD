package com.kh.jaManChw.payment.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.kh.jaManChw.dto.ShoppingBasket;

public interface PaymentService {

	public JSONObject paymentInfo(HttpServletRequest request);

	/**
	 * 파라미터로 받은 배열을 DTO에 저장해 
	 * 
	 * @param sbItemcount - 구매상품 수량
	 * @param basketno - 장바구니 번호
	 * @return 추출하여 완성된 리스트 DTO 
	 * 
	 */
	public List<ShoppingBasket> getParamList(int[] sbItemcount, int[] basketno);

}
