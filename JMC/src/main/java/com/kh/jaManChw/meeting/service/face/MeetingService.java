package com.kh.jaManChw.meeting.service.face;

import java.util.List;

import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Users;

public interface MeetingService {

	public void inputMeeting(Meeting meeting);

	public List<Users> selectFriendListAll();
	

}
