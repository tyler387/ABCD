package com.kh.jaManChw.mypage.dao.face;

import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;

public interface MypageDao {
	
	/**
	 * 유저 정보 수정
	 * @param users
	 * @return
	 */
	public int updateUserInfo(Users users);

	/**
	 * 로그인 한 유저 정보 조회
	 * @param users
	 * @return userInfo
	 */
	public Users selectUserInfo(Users users);

	/**
	 * 유저 탈퇴 처리 (유저의 상태 변경)
	 * @param users
	 * @return
	 */
	public int updateUserStatus(Users users);

	/**
	 * 전달된 파일 정보 삽입하기
	 * @param filetest
	 */
	public void insertFile(ProfileFile filetest);

}
