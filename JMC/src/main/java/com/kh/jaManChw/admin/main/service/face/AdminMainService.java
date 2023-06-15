package com.kh.jaManChw.admin.main.service.face;

import java.util.Map;

import org.springframework.stereotype.Controller;


public interface AdminMainService {

	/**
	 * 관리자 메인 페이지에 보여줄 모든 통계적인 정보를 보여준다
	 *  
	 * 
	 * @return - 관리자 메인 페이지에 보여줄 모든 통계적 정보
	 * 
	 */
	public Map<String, Object> getAllInfo();

	
}
