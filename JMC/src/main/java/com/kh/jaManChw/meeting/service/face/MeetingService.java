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
	
	public int getUserno(int userno);

	public void inputMeeting(Meeting meeting, Preference preference, Applicant applicant);
	
	public List<Meeting> getMeetinglistAll(Meeting meeting);
	
	public int getMeetinglistcount(Meeting meeting);
	
	public int getMeetinglistcountnow(Meeting meeting);
	
	public List<Meeting> getMeetingListByDate(String result);
	
	public List<Meeting> getMeetingListByMap(String mapData, String mapData1);
	
	public List<Meeting> getMeetingListByFilter(Map<String, Object> map);
	
	public List<Meeting> getMeetingListByMname(String search);
	
	public int getApplicantCount(Applicant applicant);
	
	public int getApplicantCheckCount(Applicant applicant);

	public int getApplicantNoCheckCount(Applicant applicant);
	
	public Meeting getDetailMeeting(Meeting meeting);
	
	public Preference getDetailPreference(Preference preference);
	
	public List<Users> getUserNickAgree(Meeting meeting);
	
	public List<Users> getUserNickNocheck(Meeting meeting);	
	
	public Users getUserNickLeader(Meeting meeting);
	
	public Map<String, Object> getLeaderProfile(Applicant applicant);
	
	public void inputReportMeeting(Report reportMeeting);

	public Users getMeetingApplicantUser(Users users);
	
	public int chkUser(Applicant applicant);

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
