package com.kh.jaManChw.meeting.dao.face;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.MeetingPaging;

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
	
	public void insertReportMeeting(Report reportMeeting);

	public List<Users> selectUserNickAgree(Meeting meeting);
	
	public List<Users> selectUserNickNoCheck(Meeting meeting);
	
	public Users selectMeetingApplicantLeader(Meeting meeting);
	
	public Users selectMeetingApplicantUser(Users users);

	public void insertJoinMeeting(Applicant applicant);

	public int selectUserNo(int userno);

	public void insertMeetingUser(Applicant leader);
	
	public List<Meeting> selectMeetingListByDate(String result);
	
	public List<Meeting> selectMeetingListByMap(@Param("mapData") String mapData, @Param("mapData1")String mapData1);
	
	public int selectMeetingListCount(Meeting meeting);

	public int selectMeetingListCountnow(Meeting meeting);
	
	public List<Meeting> selectMeetingListByMname(String search);

	public List<Meeting> selectMeetingListByFilter(Map<String, Object> map);

	public Preference selectDetailPreference(Preference preference);

	public int selectMeetingappcount(Meeting meeting);

	public void updateStatus(Meeting meeting);
	
	public List<Meeting> selectMyMeetingno(Meeting meeting);

	public void updateApplicantAgree(Applicant applicant);

	public int selectCnt(List<Meeting> list);

	public List<Map<String, Object>> selectApplicantPaging(@Param("list")List<Meeting> list,@Param("paging") MeetingPaging paging);

	public int selectNotFull(Applicant applicant);

	public int selectApplicantCount(Applicant applicant);

	public int selectApplicantCheckCount(Applicant applicant);

	public int selectApplicantNoCheckCount(Applicant applicant);

	public int selectMeetingAppUser(Applicant applicant);

	

	
	

	

	
	
	
	public List<Map<String, Object>> selectMyApplicant(@Param("applicant")Applicant applicant, @Param("paging")MeetingPaging paging);

	public int selectCntAll(Meeting meeting);

	public List<Map<String,Object>> selectMyMeetingList(@Param("meeting")Meeting meeting, @Param("paging")MeetingPaging paging);

	public int selectMyMeetingCntAll(Meeting meeting);

	public Map<String, Object> selectLeaderProfile(Applicant applicant);

	
	

	

	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
