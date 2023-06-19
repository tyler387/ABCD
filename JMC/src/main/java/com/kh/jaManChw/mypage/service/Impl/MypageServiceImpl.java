package com.kh.jaManChw.mypage.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
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
	public int findcntInfo(ProfileFile profileFile) {
		return mypageDao.selectCntProfile(profileFile);
	}


	@Override
	public ProfileFile profileSave(MultipartFile file,ProfileFile profileFile) {

		

		//파일 크기 0이면 업로드 중지
		if(file.getSize() <= 0) {
			logger.info("파일 크기 0 : 업로드 중단");
			return null;
		}
		
		//파일 저장 경로 - 없으면 폴더 생성
		String storedPath = context.getRealPath("userProfile");
		logger.info("storedPath : {}",storedPath);
		
		// 저장폴더 객체 생성 - 저장할 폴더생성
		File storedFolder = new File(storedPath);
		storedFolder.mkdir();
		
		File dest = null;
		String storedName = null;
		
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
		profile.setUserno(profileFile.getUserno());		
		profile.setProfileOriginName(file.getOriginalFilename());
		profile.setProfileStoredName(storedName);
		profile.setProfilesize(file.getSize());
		
		//model.addAttribute("profile", profile);
		logger.info("profile:{}",profile);

		
		// 사용자의 프로필이 저장되어 있는지 확인 있으면 삭제 없으면 삽입
		int res = mypageDao.selectCntProfile(profileFile);
			
		
		logger.info("res:{}",res);
		if(res > 0) {			
			// 저장된 파일 삭제
			mypageDao.deleteProfileName(profileFile);
			logger.info("res:{}");	
			mypageDao.insertFile(profile);				
		}else {		
		mypageDao.insertFile(profile);
		}		
		return profile;
	}


	@Override
	public ProfileFile fileInfo(Users info) {
		return mypageDao.selectfileInfo(info.getUserno());
	}


	@Override
	public ProfileFile getFileName(ProfileFile profileFile) {
		return mypageDao.selectFileName(profileFile);
	}

	@Override
	public List<Users> getSearchLists(String type,String keyword) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("keyword", keyword);
		
		return mypageDao.selectSearchList(map);
	
	}


	@Override
	public List<Map<String, Object>> getFriendList(Users users) {
		return mypageDao.selectFriendAll(users);
	}


	@Override
	public void friendAdd(FriendList friendList) {
		int res = mypageDao.selectCntFriend(friendList);
		
		if(res>0) {
			logger.info("우린 친구야");
		}else {
			mypageDao.insertFriend(friendList);
			logger.info("친구추가");
		}

	}


	@Override
	public List<BoardFile> getMyboardFile(Users users) {
		return mypageDao.selectMyboard(users);
	}


	@Override
	public void removeFriend(int userno) {
		mypageDao.deleteFriend(userno);
		
	}





	





}
