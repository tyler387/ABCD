package com.kh.jaManChw.mypage.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.mypage.dao.face.MypageDao;
import com.kh.jaManChw.mypage.service.face.MypageService;
import com.kh.jaManChw.util.Paging;


@Service
public class MypageServiceImpl implements MypageService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired MypageDao mypageDao;
	
	//서블릿 컨텍스트 객체
	@Autowired ServletContext context;
	
	
	@Override
	public int changeInfo(Users users) {
		return mypageDao.updateUserInfo(users);
	}
	
	
	@Override
	public Users getloginInfo(Users users) {
		return mypageDao.selectUserInfo(users);
	}


	@Override
	public int deleteUser(Users users) {
		return mypageDao.updateUserStatus(users);
	}


	@Override
	public void profileSave(MultipartFile file,HttpSession session,ProfileFile profileFile) {


		//파일 크기 0이면 업로드 중지
		if(file.getSize() <= 0) {
			logger.info("파일 크기 0 : 업로드 중단");
			return;
		}
		
		//파일 저장 경로 - 없으면 폴더 생성
		String storedPath = context.getRealPath("userProfile");
		logger.info("storedPath : {}",storedPath);
		
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		File dest = null;
		String storedName = null;
		String profileImgUrl = "";
		do {
			
			// 보통은 중복될일이 극히 드물지만 혹지 몰라 해두는 것.
			//저장할 파일 이름 생성하기
			storedName = file.getOriginalFilename(); // DNJSQHS VKDLFUAD
			storedName += UUID.randomUUID().toString().split("-")[0]; // UUID추가
			
			
			logger.info("storedName : {}" , storedName);
			
			//실제 저장될 파일 객체
			dest = new File(storedFolder, storedName);
			
			} while(dest.exists());
			
			try {
				
				//업로드된 파일을 upload폴더에 저장하기
				// wirte, delete 해주던거- multipart에 속한 메소드
				// 우리는 commons- mulitpart 사용 
				file.transferTo(dest);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		//db에 기록할 정보 객체
		ProfileFile profile = new ProfileFile();
		
		//세션을 profile에 삽입
		profile.setUserno((Integer)session.getAttribute("userno"));		
		profile.setProfileOriginName(file.getOriginalFilename());
		profile.setProfileStoredName(storedName);
		profile.setProfilesize(file.getSize());
		
		//model.addAttribute("profile", profile);
		logger.info("profile:{}",profile);

		//insertFile() 호출
		mypageDao.insertFile(profile);

	}



	@Override
	public ProfileFile fileInfo(ProfileFile profileFile,Model model) {
		return mypageDao.selectfileInfo(profileFile);
	}


	@Override
	public void removeProfile(ProfileFile profileFile) {

		mypageDao.deleteProfileName(profileFile);
	}


	@Override
	public int findcntInfo(ProfileFile profileFile) {
		return mypageDao.selectCntProfile(profileFile);
	}








	


}
