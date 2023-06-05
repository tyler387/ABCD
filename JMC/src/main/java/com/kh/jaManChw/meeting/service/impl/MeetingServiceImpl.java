package com.kh.jaManChw.meeting.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.controller.MeetingController;
import com.kh.jaManChw.meeting.dao.face.MeetingDao;
import com.kh.jaManChw.meeting.service.face.MeetingService;



@Component
public class MeetingServiceImpl implements MeetingService{

private final Logger logger = LoggerFactory.getLogger(MeetingController.class);
	
@Autowired MeetingDao meetingDao;	
	
	@Override
	public void inputMeeting(Meeting meeting, Preference preference, Applicant applicant, Applicant leader) {
		
		
		int meetingno = meetingDao.selectMeetingno();
		
		meeting.setMeetingno(meetingno);
		
		meetingDao.insertMeeting(meeting);
		
		preference.setMeetingno(meetingno);
		
		meetingDao.insertPreference(preference);
		
		applicant.setMeetingno(meetingno);
		
		meetingDao.insertMeetingFriend( applicant);
		
		leader.setMeetingno(meetingno);
		
		meetingDao.insertMeetingUser(leader);
	}
	
	@Override
	public List<Users> selectFriendListAll(int userno) {
		
		return meetingDao.selectFriendListAll(userno);
	}
	
	@Override
		public int getUserno(int userno) {
		
			return meetingDao.selectUserNo(userno);
		}
	
	
	@Override
		public List<Meeting> getMeetinglistAll() {
		
		
		return meetingDao.selectMeetinglistAll();
	}
	
	
	
	@Override
		public Meeting detailMeeting(Meeting meeting) {
		
		
		return meetingDao.selectMeeting(meeting);
	}
	
	@Override
		public void inputReportMeeting(ReportMeeting reportMeeting) {		
		
		meetingDao.insertReportMeeting(reportMeeting);
		
	}
	


	@Override
	public List<Users> getUserNickAll(Meeting meeting) {
		
		return meetingDao.selectUserNickAll(meeting);
	}
	
	
	@Override
		public Applicant getMeetingApplicant(Applicant applicant) {
		
		return meetingDao.selectMeetingApplicant(applicant);
	}
	
	
	@Override
		public Users getMeetingApplicantUser(Users users) {
		
			return meetingDao.selectMeetingApplicantUser(users);
		}
	
	@Override
		public void inputJoinMeeting(Applicant applicant) {
		
			meetingDao.insertJoinMeeting(applicant);
			
		}

	@Override
	public List<Meeting> getMeetingByDate(String result) {

		
		return meetingDao.selectMeetingByDate(result);
	}

	@Override
	public int getMeetinglistcount(Meeting meeting) {
		
		return meetingDao.selectMeetingListCount(meeting);
	}
	
	
	@Override
		public List<Meeting> meetingsearch(String search) {
		
			return meetingDao.selectMeetingListByMname(search);
		}
	
	@Override
		public List<Meeting> meetingFilter(Map<String, Object> map) {
		
			return meetingDao.selectMeetingListByFilter(map);
		}
	
	@Override
		public List<Meeting> getMeetingByMap(String mapData, String mapData1) {
		
			return meetingDao.selectMeetingListByMap(mapData,mapData1);
		}

}
