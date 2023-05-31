package com.kh.jaManChw.meeting.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.meeting.service.face.MeetingService;


@Controller
public class MeetingController {
	
@Autowired MeetingService meetingService;
	
private final Logger logger = LoggerFactory.getLogger(MeetingController.class);


	@GetMapping("/meeting/form")
	public String meetingWriteForm() {
		
		logger.info("/meeting/form [GET]");
		
		return "/meeting/form";
	}
	
	@PostMapping("/meeting/form")
	public String meetingWrite(Meeting meeting ) {
		
		
		logger.info("/meeting/form [POST]");

		meetingService.inputMeeting(meeting);
		
		
		
		return "/meeting/list";
	}
	
	
}
