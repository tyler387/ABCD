package com.kh.jaManChw.payment.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.dto.Payment;
import com.kh.jaManChw.dto.ShoppingBasket;
import com.kh.jaManChw.payment.dao.face.PaymentDao;
import com.kh.jaManChw.payment.service.face.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired PaymentDao paymentDao;
	
	
	
	@Override
	public JSONObject paymentInfo(HttpServletRequest request, Map<String, String> map, int[] basketno, String[] itemTitle) {
		
		String orderId = request.getParameter("orderId");
		String paymentKey = request.getParameter("paymentKey");
		String amount = request.getParameter("amount");
		String secretKey = "test_sk_k6bJXmgo28evgEjWYDj3LAnGKWx4:";

		JSONObject jsonObject = null;
		
		Encoder encoder = Base64.getEncoder(); 
		byte[] encodedBytes;
		HttpURLConnection connection = null;
		int code = 0;
		try {
			encodedBytes = encoder.encode(secretKey.getBytes("UTF-8"));
			String authorizations = "Basic "+ new String(encodedBytes, 0, encodedBytes.length);

			paymentKey = URLEncoder.encode(paymentKey, StandardCharsets.UTF_8);

			URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");

			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", authorizations);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			JSONObject obj = new JSONObject();
			obj.put("paymentKey", paymentKey);
			obj.put("orderId", orderId);
			obj.put("amount", amount);
			
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(obj.toString().getBytes("UTF-8"));
			
			code = connection.getResponseCode();
			boolean isSuccess = code == 200 ? true : false;
			
			InputStream responseStream = isSuccess? connection.getInputStream(): connection.getErrorStream();
			
			Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(reader);
			
			responseStream.close();
			
			   if (isSuccess) {
					 //결제 성공
					      logger.info("결과 데이터 : {}", jsonObject.toJSONString()); 
					      logger.info("orderName : {}", jsonObject.get("orderName")); 
					      logger.info("method : {}", jsonObject.get("method")); 
					         
				         if(jsonObject.get("method").equals("카드")) {  logger.info("method : {}",(((JSONObject)jsonObject.get("card")).get("number")));}
				         if(jsonObject.get("method").equals("가상계좌")) { logger.info("method : {}",(((JSONObject)jsonObject.get("virtualAccount")).get("accountNumber")));} 
				         if(jsonObject.get("method").equals("계좌이체")) { logger.info("method : {}",(((JSONObject)jsonObject.get("transfer")).get("bank")));}
				         if(jsonObject.get("method").equals("휴대폰")) { logger.info("method : {}",(((JSONObject)jsonObject.get("mobilePhone")).get("customerMobilePhone")));}     
					            
					     } else { 
					 	//결제 실패
						      logger.info("method : {}", jsonObject.get("message")); 
						      logger.info("에러코드 : {}", jsonObject.get("code") ); 
					     }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int oncetrypayno = paymentDao.selectOncetrypayno();
		
		int abc = itemTitle.length - 1;
		String abb = itemTitle[0] +" 외 " + abc + "건";
		
		logger.info("상품명 :  {}", abb);
		
//		Payment payment = new Payment();
//		payment.setOrderName((String)jsonObject.get("orderName"));
//		paymentDao.insertPayment(payment);
		
		logger.info("{}", jsonObject);
		
		return jsonObject;
	}

	@Override
	public List<Map<String, String>> getParamList(int[] basketno) {

		List<Map<String, String>> sbList = new ArrayList<Map<String, String>>();
//		Map<String, Object> map = new HashMap<>();
		// 배열을 사용하여 원하는 작업 수행
		for (int i : basketno) {
//			map.put("sbList", paymentDao.selectShoppingAllBasketList(shoppingBasket));
			sbList.add(paymentDao.selectShoppingAllBasketList(i));
			logger.info("sbList {}", sbList);
		}
		logger.info("장바구니쇼핑 리스트 {}", sbList);
		return sbList;
	}

}
