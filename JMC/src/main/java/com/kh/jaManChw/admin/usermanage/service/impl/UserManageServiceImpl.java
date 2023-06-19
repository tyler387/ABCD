package com.kh.jaManChw.admin.usermanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.usermanage.dao.face.UserManageDao;
import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

@Service
public class UserManageServiceImpl implements UserManageService {

	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired UserManageDao userManageDao;
	
	@Override
	public List<Users> UserMgPage(Paging paging) {
		
		return userManageDao.selectUserMgPage(paging);
	}

	@Override
	public List<Users> getUserMgFiltering(Map<String, Object> map) {
		
		return userManageDao.selectUserMgFiltering(map);
	}

	@Override
	public Paging getpaging(String ccurpage) {
		
		//전달파라미터 curPage 추출
		
		String param = ccurpage;
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] BoardService - getPaging() : curPage값이 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = userManageDao.selectCntAll();
		
		//페이징 객체
//		Paging paging = new Paging(totalCount, curPage, 30, 5); //listCount:30, pageCount:5
		Paging paging = new Paging(curPage, totalCount);
		
		return paging;
	}

	@Override
	public Map<String, String> getUserData(int userno) {
		
		int profile = userManageDao.selectUserProfile(userno);
		
		if(profile > 0) {
			return userManageDao.getUserdataProfile(userno);
		}else {
			return userManageDao.getUserdata(userno);
		} 
	}
	
	@Override
	public void reviseUserMgWithdraw(int userno) {
		userManageDao.deleteUserMgWithdraw(userno);
	}

	@Override
	public Paging getFilterPaging(String ccurpage, Map<String, Object> map) {
		
		//전달파라미터 curPage 추출
		
		String param = ccurpage;
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] BoardService - getPaging() : curPage값이 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = userManageDao.selectFilterCntAll(map);
		
		//페이징 객체
//		Paging paging = new Paging(totalCount, curPage, 30, 5); //listCount:30, pageCount:5
		Paging paging = new Paging(curPage, totalCount);
		
		return paging;
	}
	
	@Override
	public void reviseUserBlackUpdate(int userno) {
		
		userManageDao.updateUserBlackUpdate(userno);
	}
	
	@Override
	public void reviseUserBlackStop(int userno) {
		userManageDao.updateUserBlackStop(userno);
		
	}

	@Override
	public void reviseUserMgUpdate(Map<String, Object> map) {
	
		userManageDao.updateUserMgUpdate(map);
	}
	


}

