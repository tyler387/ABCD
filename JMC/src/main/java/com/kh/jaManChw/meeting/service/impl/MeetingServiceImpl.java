package com.kh.jaManChw.meeting.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.controller.MeetingController;
import com.kh.jaManChw.meeting.dao.face.MeetingDao;
import com.kh.jaManChw.meeting.service.face.MeetingService;



@Component
public class MeetingServiceImpl implements MeetingService{

private final Logger logger = LoggerFactory.getLogger(MeetingController.class);
	
@Autowired MeetingDao meetingDao;	
	
	@Override
	public void inputMeeting(Meeting meeting) {
		
		meetingDao.insertMeeting(meeting);
			
	}
	
	@Override
	public List<Users> selectFriendListAll() {
		
		return meetingDao.selectFriendListAll();
	}
}
