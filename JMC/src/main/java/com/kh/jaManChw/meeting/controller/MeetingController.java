package com.kh.jaManChw.meeting.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.service.face.MeetingService;


@Controller
public class MeetingController {
	
@Autowired MeetingService meetingService;
	
private final Logger logger = LoggerFactory.getLogger(MeetingController.class);


	@GetMapping("/meeting/form")
	public String meetingWriteForm(Model model) {
		
		logger.info("/meeting/form [GET]");
		
		List<Users> friendList = meetingService.selectFriendListAll();
		
		logger.info("{}", friendList);
		
		model.addAttribute("friendList", friendList);
		
		
		return "/meeting/form";
	}
	
	@PostMapping("/meeting/form")
	public String meetingWrite(Meeting meeting ) {
		
		
		logger.info("/meeting/form [POST]");

		meetingService.inputMeeting(meeting);
		
		
		
		return "/meeting/list";
	}
	
	
}
