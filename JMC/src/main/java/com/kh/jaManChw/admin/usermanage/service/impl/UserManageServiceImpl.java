package com.kh.jaManChw.admin.usermanage.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.usermanage.dao.face.UserManageDao;
import com.kh.jaManChw.admin.usermanage.service.face.UserManageService;
import com.kh.jaManChw.dto.Users;

@Service
public class UserManageServiceImpl implements UserManageService {

	
	//log4j.xml에서 <logger> 설정 필요
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired UserManageDao userManageDao;
	
	@Override
	public List<Users> UserMgPage() {
		
		logger.info("service");
		
		return userManageDao.selectUserMgPage();
	}

}
