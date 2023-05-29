package com.kh.jaManChw.meeting.dao.face;

import java.util.List;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;

public interface MeetingDao {

	public void insertMeeting(Meeting meeting);

	public List<Users> selectFriendListAll(int userno);

	public int selectMeetingno();

	public void insertPreference(Preference preference);

	public List<Meeting> selectMeetinglistAll();

	public Meeting selectMeeting(Meeting meeting);

	public void insertReportMeeting(ReportMeeting reportMeeting);

	public List<Users> selectUserNickAll(Meeting meeting);

	public Applicant selectMeetingApplicant(Applicant applicant);

	public Users selectMeetingApplicantUser(Users users);

	public void insertJoinMeeting(Applicant applicant);

	public int selectUserNo(int userno);
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
