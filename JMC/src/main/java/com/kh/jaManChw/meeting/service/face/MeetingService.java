package com.kh.jaManChw.meeting.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.MeetingPaging;

public interface MeetingService {
	
	public List<Users> selectFriendListAll(int userno);

	public void inputMeeting(Meeting meeting, Preference preference, Applicant applicant, Applicant leader);

	public int getUserno(int userno);
	
	public List<Meeting> getMeetinglistAll(Meeting meeting);
	

	public Meeting detailMeeting(Meeting meeting);

	public List<Users> getUserNickAll(Meeting meeting);

	public Users getUserNickLeader(Meeting meeting);
	
	public void inputReportMeeting(ReportMeeting reportMeeting);

	public Applicant getMeetingApplicant(Applicant applicant);

	public Users getMeetingApplicantUser(Users users);

	public void inputJoinMeeting(Applicant applicant);

	public List<Meeting> getMeetingByDate(String result);

	public int getMeetinglistcount(Meeting meeting);

	public List<Meeting> meetingsearch(String search);

	public List<Meeting> meetingFilter(Map<String, Object> map);

	public List<Meeting> getMeetingByMap(String mapData, String mapData1);

	public int getMeetinglistcountnow(Meeting meeting);

	public Preference detailPreference(Preference preference);

	public int getMeetingappcount(Meeting meeting);
	
	

	public List<Map<String, Object>> getApplicantInfo(HttpSession session);

	public void updateApplicant(Applicant applicant);

	public MeetingPaging getPaging(String curPage, HttpSession session);

	public List<Map<String, Object>> getApplicantAll(HttpSession session, MeetingPaging paging);

	public boolean chkHeadCount(Applicant applicant);

	public MeetingPaging getappliPaging(String curPage, HttpSession session);

	public List<Map<String, Object>> getMyapplicant(HttpSession session, MeetingPaging paging);

	public List<Map<String,Object>> getMyMeeting(HttpSession session, MeetingPaging paging);

	public MeetingPaging getMyMeetingCount(String curPage, HttpSession session);


	
	
	
	
	

	

	

	
	
	
	

	
	
	

	
	
	
	

	
	
	
	

}
