package com.kh.jaManChw.dto;

public class Payment {
	
	private String orderName;  // 결제한 상품들
	private String paymentKey; // 결제에 대한 pk같은 번호
	private String amount;   // 총 결제금액
	private String approvedAt; // 결제된 시간
	private String requestedAt; // 결제 요청된 시간
	private String status;  // 상태
	private String method;  // 결제 종류(카드, 가상계좌, 계좌이체, 휴대폰, 간편결제(토스 같은 거 ))

	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Payment [orderName=" + orderName + ", paymentKey=" + paymentKey + ", amount=" + amount + ", approvedAt="
				+ approvedAt + ", requestedAt=" + requestedAt + ", status=" + status + ", method=" + method + "]";
	}


	public Payment(String orderName, String paymentKey, String amount, String approvedAt, String requestedAt,
			String status, String method) {
		super();
		this.orderName = orderName;
		this.paymentKey = paymentKey;
		this.amount = amount;
		this.approvedAt = approvedAt;
		this.requestedAt = requestedAt;
		this.status = status;
		this.method = method;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public String getPaymentKey() {
		return paymentKey;
	}


	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getApprovedAt() {
		return approvedAt;
	}


	public void setApprovedAt(String approvedAt) {
		this.approvedAt = approvedAt;
	}


	public String getRequestedAt() {
		return requestedAt;
	}


	public void setRequestedAt(String requestedAt) {
		this.requestedAt = requestedAt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
}
