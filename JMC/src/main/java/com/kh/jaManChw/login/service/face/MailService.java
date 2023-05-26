package com.kh.jaManChw.login.service.face;

public interface MailService {

	/**
	 * email인증
	 * @param email
	 * @return 인증번호
	 */
	public String emailAuth(String email);
	

}
