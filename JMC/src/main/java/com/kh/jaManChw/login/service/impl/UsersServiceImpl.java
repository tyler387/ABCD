package com.kh.jaManChw.login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.login.dao.face.UsersDao;
import com.kh.jaManChw.login.service.face.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UsersDao usersDao;
	
	//유저 정보 가져오기
	@Override
	public Users getuserInfo(Users users) {
		return usersDao.selectuserByUserId(users);
	}

	// 로그인 유무
	@Override
	public boolean login(Users users) {
		
		// 파라미터 값을 가져와 dao에서 일치하는 행을 확인해야함.
		// 매개변수 다시 확인해보기
		int res = usersDao.selectCntByUserIdPw(users);
		
		// 유저 유저 아이디로 role가져오기 (admin, user 구분)
		String role = usersDao.selectroleByuseridpw(users);
		
		if(res>0) {
			logger.info("login() - 로그인 성공");		
			return true;
		}else {		
			logger.info("login() - 로그인 실패");			
			return false;
		}
	}

	@Override
	public void join(Users users) {
		// insert문 호출
		logger.info("join:{}",users);
		usersDao.insertUsers(users);
	}
	

	@Override
	public int IdCheck(String userId) {
				
		return usersDao.selectCntByUserId(userId);
	}

	@Override
	public Users searchName(Users users) {
		return usersDao.selectUserNameByUserId(users);
	}

	@Override
	public int searchCntId(Users users) {
		return usersDao.selectcheckCntByUserId(users);
	}

	@Override
	public int modifyPw(Users users) {
		
		return usersDao.updateByUserPw(users);		
	}

	@Override
	public Users searchId(Users users) {
		return usersDao.selectIdByUserNameEmail(users);
	}

	@Override
	public boolean blackLogin(Users users) {
		
		int status = usersDao.selectStatusbyUserId(users);
		
		
		if(status>0) {
			logger.info("status:{}",status);
			logger.info("당신은 블랙리스트! 로그인 불가");
			return true;
		}else {
			logger.info("관리자에게 문의바람");
			return false;
		}
		
		
	}

	@Override
	public boolean leaveLogin(Users users) {
		
		int leave = usersDao.selectLeaveUserByUserId(users);
		
		if(leave>0) {
			logger.info("당신은 탈퇴유저");
			return true;
		}else {
			logger.info("관리자에게 문의바람");
			return false;
		}
		
	}


	
	@Override
	public int isNaverUser(String userId) {
		return usersDao.selectCntByUserId(userId);
	}
	 

	@Override
	public void joinUsersNaver(Users userInfo) {
		usersDao.insertNaverUser(userInfo);
	}




	
}
