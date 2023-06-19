package com.kh.jaManChw.mypage.dao.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.BoardFile;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

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

	/**
	 * 유저의 프로필 사진 수정하기
	 * @param profile
	 * @param users 
	 */
	public void updateProfile(Users users);



	/**
	 * 프로필 사진 삭제
	 * @param profileFile
	 */
	public void deleteProfileName(ProfileFile profileFile);

	/**
	 *  프로필 사진 조회
	 * @param profileFile
	 * @return
	 */
	public int selectCntProfile(ProfileFile profileFile);



	public ProfileFile selectfileInfo(int i);

	/**
	 * userno로 파일 이름 조회하기
	 * @param profileFile
	 * @return
	 */
	public ProfileFile selectFileName(ProfileFile profileFile);

	/**
	 * keyword와 type값으로 유저 검색
	 * @param map
	 * @return
	 */
	public List<Users> selectSearchList(Map<String, String> map);

	/**
	 * 유저 넘버로 친구목록 조회
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectFriendAll(Users users);

	/**
	 * userno로 친구 추가하기
	 * @param friendList
	 * @return
	 */
	public int insertFriend(FriendList friendList);

	/**
	 * 내가 올린 사진게시물 조회하기
	 * @param users
	 * @return 내가 올린 사진 파일
	 */
	public List<BoardFile> selectMyboard(Users users);

	/**
	 * 친구가 됐는지 행 조회
	 * @param friendList
	 * @return
	 */
	public int selectCntFriend(FriendList friendList);

	/**
	 * 친구삭제
	 * @param userno
	 */
	public void deleteFriend(int userno);



	


	




}
