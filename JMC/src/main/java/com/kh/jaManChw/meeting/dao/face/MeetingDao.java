package com.kh.jaManChw.meeting.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;

public interface MeetingDao {
	
	
	/**
	 * 모임 등록 정보 삽입하기 
	 * 
	 * @param meeting - 등록될 모임 정보  
	 */
	public void insertMeeting(Meeting meeting);
	
	/**
	 * 사용자의 모든 친구 목록 조회하기
	 * 
	 * @param userno - 사용자의 정보  
	 * @return 사용자의 모든 친구 목록 
	 */
	public List<Users> selectFriendListAll(int userno);

	
	/**
	 * 
	 * 
	 * @return
	 */
	public int selectMeetingno();

	public void insertPreference(Preference preference);

	public List<Meeting> selectMeetinglistAll();

	public Meeting selectMeeting(Meeting meeting);

	public void updatehit(Meeting meeting);
	
	public void insertReportMeeting(ReportMeeting reportMeeting);

	public List<Users> selectUserNickAgree(Meeting meeting);
	
	public List<Users> selectUserNickNoCheck(Meeting meeting);
	
	public Users selectMeetingApplicantLeader(Meeting meeting);
	
	public Applicant selectMeetingApplicant(Applicant applicant);

	public Users selectMeetingApplicantUser(Users users);

	public void insertJoinMeeting(Applicant applicant);

	public int selectUserNo(int userno);

	public void insertMeetingFriend(Applicant applicant);

	public void insertMeetingUser(Applicant leader);
	
	public List<Meeting> selectMeetingByDate(String result);

	public int selectMeetingListCount(Meeting meeting);

	public int selectMeetingListCountnow(Meeting meeting);
	
	public List<Meeting> selectMeetingListByMname(String search);

	public List<Meeting> selectMeetingListByFilter(Map<String, Object> map);

	public List<Meeting> selectMeetingListByMap(@Param("mapData") String mapData, @Param("mapData1")String mapData1);

	public Preference selectDetailPreference(Preference preference);

	public int selectMeetingappcount(Meeting meeting);

	public void updatestatus(Meeting meeting);
	

	public List<Meeting> selectMyMeetingno(Meeting meeting);

	public List<Applicant> selectAllApplicant(List<Meeting> list);

	public int selectApplicantCount(Applicant applicant);

	public int selectApplicantCheckCount(Applicant applicant);

	public int selectApplicantNoCheckCount(Applicant applicant);

	public int selectMeetingAppUser(Applicant applicant);

	public ProfileFile selectFileInfo(Users info);

	public List<Map<String, Object>> selectAllInfo(Applicant applicant);
	

	
	

	

	
	
	
	

	
	

	

	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
