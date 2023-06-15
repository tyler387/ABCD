package com.kh.jaManChw.admin.main.dao.face;

import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;

public interface AdminMainDao {

	/**
	 * 오늘 가입한 회원의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 회원수
	 */
	public int selectCntTodayJoinUsers(String today);

	/**
	 * 오늘 가입한 회원리스트를 조회하여 반환한다
	 * 
	 * @param today
	 * @return 회원리스트
	 */
	public List<Map<String, Object>> selectTodayJoinUsers(String today);

	/**
	 * 오늘 작성된 게시글의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 게시글 수
	 */
	public int selectCntTodayWriteBoards(String today);

	/**
	 * 오늘 작성된 게시글 리스트를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 게시글 리스트
	 */
	public List<Map<String, Object>> selectTodayWriteBoards(String today);

	/**
	 * 오늘 작성된 신고글(게시글)의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(게시글) 수
	 */
	public int selectCntTodayWriteReportBoards(String today);

	/**
	 * 오늘 작성된 신고글(게시글)리스트를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(게시글) 리스트
	 */
	public List<Map<String, Object>> selectTodayWriteReportBoards(String today);

	/**
	 * 오늘 작성된 신고글(계정)의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(계정) 수
	 */
	public int selectCntTodayWriteReportUsers(String today);
	
	/**
	 * 오늘 작성된 신고글(계정) 리스트를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(계정) 리스트
	 */
	public List<Map<String, Object>> selectTodayWriteReportUsers(String today);

	/**
	 * 
	 * 오늘 작성된 신고글(모임)의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(모임) 수
	 */
	public int selectCntTodayWriteReportMeetings(String today);

	/**
	 * 오늘 작성된 신고글(모임)의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 신고글(모임) 리스트
	 */
	public List<Map<String, Object>> selectTodayWriteReportMeetings(String today);

	/**
	 * 오늘 생성된 모임의 수를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 모임 수
	 */
	public int selectCntTodayWriteMeetings(String today);

	/**
	 * 오늘 생성된 모임 리스트를 조회하여 반환한다
	 * 
	 * @param today - 오늘 날짜
	 * @return 모임 리스트
	 */
	public List<Map<String, Object>> selectTodayWriteMeetings(String today);






}
