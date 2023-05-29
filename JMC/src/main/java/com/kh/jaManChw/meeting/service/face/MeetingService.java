package com.kh.jaManChw.meeting.service.face;

import java.util.List;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;

public interface MeetingService {
	
	public List<Users> selectFriendListAll(int userno);

	public void inputMeeting(Meeting meeting , Preference preference);

	public int getUserno(int userno);
	
	public List<Meeting> getMeetinglistAll();

	public Meeting detailMeeting(Meeting meeting);

	public List<Users> getUserNickAll(Meeting meeting);

	public void inputReportMeeting(ReportMeeting reportMeeting);

	public Applicant getMeetingApplicant(Applicant applicant);

	public Users getMeetingApplicantUser(Users users);

	public void inputJoinMeeting(Applicant applicant);
	
	
	

	
	
	

	
	
	
	

	
	
	
	

}
