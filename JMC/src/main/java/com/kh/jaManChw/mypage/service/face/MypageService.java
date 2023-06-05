package com.kh.jaManChw.mypage.service.face;

import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;

public interface MypageService {

	/**
	 *  유저 정보 수정
	 * @param users
	 * @return 1: 수정 성공, 0: 수정 실패
	 */
	public int changeInfo(Users users);

	/**
	 * 로그인한 유저의 유저 정보
	 * @param users
	 * @return loginInfo
	 */
	public Users getloginInfo(Users users);

	/**
	 * 회원 탈퇴
	 * @param users
	 * @return 1: 탈퇴 성공, 0: 탈퇴 실패
	 */
	public int deleteUser(Users users);

	/**
	 * 
	 * @param file
	 * @param profileFile
	 */
	public void profileSave(MultipartFile file, ProfileFile profileFile);
	

}
