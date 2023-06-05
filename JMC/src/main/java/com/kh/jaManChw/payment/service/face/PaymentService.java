package com.kh.jaManChw.payment.service.face;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

public interface PaymentService {

	JSONObject paymentInfo(HttpServletRequest request);

}
