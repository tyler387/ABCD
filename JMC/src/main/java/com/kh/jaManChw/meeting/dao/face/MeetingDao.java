package com.kh.jaManChw.meeting.dao.face;

import java.util.List;

import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Users;

public interface MeetingDao {

	public void insertMeeting(Meeting meeting);

	public List<Users> selectFriendListAll();
	

}
