package com.kh.jaManChw.meeting.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.MeetingPaging;

public interface MeetingService {
	
	/**
	 * 유저정보 가져오기 
	 * @param userno 
	 * @return  
	 * 
	 */
	public int getUserno(int userno);
	
	/**
	 * 모임 등록하기   
	 * @param meeting
	 * @param preference
	 * @param applicant
	 */
	public void inputMeeting(Meeting meeting, Preference preference, Applicant applicant);
	
	/**
	 * 전체 모임 조회하기 
	 * @param meeting 모임 정보 
	 * @return 전체 모임 목록 
	 */
	public List<Meeting> getMeetinglistAll(Meeting meeting);
	
	/**
	 * 등록된 모임 개수 조회하기  
	 * @param meeting 모임 정보 
	 * @return 전체 모임 개수 
	 */
	public int getMeetinglistcount(Meeting meeting);
	
	/**
	 * 등록된 모집중인 모임 조회하기  
	 * @param meeting 모임 정보 
	 * @return 모집중인 모임 개수 
	 */
	public int getMeetinglistcountnow(Meeting meeting);
	
	/**
	 * 선택한 날짜에 맞는 모임 조회하기  
	 * @param result 선택한 날짜 
	 * @return 날짜에 맞는 모임 목록 
	 */
	public List<Meeting> getMeetingListByDate(String result);
	
	/**
	 * 선택한 위치에 맞는 모임 조회하기 
	 * @param mapData 선택한 도로명 주소 
	 * @param mapData1 선택한 상세 주소 
	 * @return 위치에 맞는 모임 목록 
	 */
	public List<Meeting> getMeetingListByMap(String mapData, String mapData1);
	
	/**
	 * 필터에 맞는 모임 목록 조회하기 
	 * @param map 필터로 선택한 인원수, 요금 
	 * @return 필터에 맞는 모임 목록 
	 */
	public List<Meeting> getMeetingListByFilter(Map<String, Object> map);
	
	/**
	 * 검색한 단어에 맞는 제목의 모임 목록 조회하기  
	 * @param search 검색내용 
	 * @return 검색한 단어에 맞는 제목의 모임 목록 
	 */
	public List<Meeting> getMeetingListByMname(String search);
	
	/**
	 * 모임의 신청자 수 조회하기  
	 * @param applicant 신청자 정보 
	 * @return 신청자 수 
	 */
	public int getApplicantCount(Applicant applicant);
	
	/**
	 * 모임에 확정된 신청자 수 조회하기  
	 * @param applicant 신청자 정보 
	 * @return 확정된 신청자 수 
	 */
	public int getApplicantCheckCount(Applicant applicant);

	/**
	 * 모임에 확정되지 않은 신청자 수 조회하기 
	 * @param applicant 신청자 정보 
	 * @return 확정되지 않은 신청자 수 
	 */
	public int getApplicantNoCheckCount(Applicant applicant);
	
	/** 
	 * 선택한 모임 조회하기   
	 * @param meeting 모임의 정보  
	 * @return 선택한 모임 정보 
	 */
	public Meeting getDetailMeeting(Meeting meeting);
	
	/**
	 * 선택한 모임의 선호타입 조회하기
	 * @param preference
	 * @return
	 */
	public Preference getDetailPreference(Preference preference);
	
	/** 
	 * 선택한 모임의 확정된 신청자 정보 가져오기 
	 * @param meeting 선택한 모임 
	 * @return 모임에 확정된 신청자 정보 
	 */
	public List<Users> getUserNickAgree(Meeting meeting);
	
	/**
	 * 선택한 모임의 확정 안된 신청자 정보 가져오기 
	 * @param meeting 선택한 모임 
	 * @return 모임에 확정 안된 신청자 정보 
	 */
	public List<Users> getUserNickNocheck(Meeting meeting);	
	
	/**
	 * 선택한 모임의 모집자 정보 가져오기  
	 * @param meeting 선택한 모임 
	 * @return 모임을 등록한 모집자 정보 
	 */
	public Users getUserNickLeader(Meeting meeting);
	
	/** 
	 * 선택한 모임의 모집자 프로필 가져오기  
	 * @param applicant 신청자 정보 
	 * @return 모임을 등록한 모집자의 프로필 
	 */
	public Map<String, Object> getLeaderProfile(Applicant applicant);
	
	/** 
	 * 모임 신고하기 
	 * @param reportMeeting 신고할 모임 
	 */
	public void inputReportMeeting(Report reportMeeting);

	/** 
	 * 모임 모집자의 정보 가져오기 
	 * @param users 모집자의 정보 
	 * @return 선택한 모임 모집자의 정보 
	 */
	public Users getMeetingApplicantUser(Users users);
	
	/** 
	 * 신청자의 모임 신청횟수 가져오기  
	 * @param applicant 신청자의 신청횟수 
	 * @return 신청자의 신청 횟수 
	 */
	public int chkUser(Applicant applicant);
	
	/**
	 * 모임에 신청하기  
	 * @param applicant 신청자 정보 
	 */
	public void inputJoinMeeting(Applicant applicant);
	
	
	//여기까지 meetingcontroller
	


	
	public int getMeetingappcount(Meeting meeting);

	
	public void updateApplicant(Applicant applicant);

	public MeetingPaging getPaging(String curPage, HttpSession session);

	public List<Map<String, Object>> getApplicantAll(HttpSession session, MeetingPaging paging);

	public boolean chkHeadCount(Applicant applicant);

	
	public MeetingPaging getappliPaging(String curPage, HttpSession session);

	public List<Map<String, Object>> getMyapplicant(HttpSession session, MeetingPaging paging);

	public List<Map<String,Object>> getMyMeeting(HttpSession session, MeetingPaging paging);

	public MeetingPaging getMyMeetingCount(String curPage, HttpSession session);

		
	
	

}
