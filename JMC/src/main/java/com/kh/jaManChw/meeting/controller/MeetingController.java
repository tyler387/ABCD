package com.kh.jaManChw.meeting.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.FriendList;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ReportMeeting;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.service.face.MeetingService;

import oracle.jdbc.proxy.annotation.Post;


@Controller
public class MeetingController {
	
@Autowired MeetingService meetingService;
	
private final Logger logger = LoggerFactory.getLogger(MeetingController.class);

	//모임 작성 폼으로 이동 
	@GetMapping("/meeting/form")
	public String meetingWriteForm(Meeting meeting , Model model, HttpSession session) {
		
		logger.info("/meeting/form [GET]");
		
		int userno = (int)session.getAttribute("userno");
		meeting.setUserno(meetingService.getUserno(userno));
		
		logger.info("{}!!!" , userno);
		
		//모임 작성 폼에 가져올 친구 목록 조회
		List<Users> friendList = meetingService.selectFriendListAll(userno);
		
		logger.info("{}", friendList);
	
		//모델에 모임 작성 폼에 가져올 친구 목록 담아주기 
		model.addAttribute("friendList", friendList);
		String url = "";
		
		//로그인 세션 처리 
		if((session.getAttribute("login")==null)) {
			
			url = "redirect: /login/login";
			
		} else {  
			
			url = "/meeting/form";
		}
		return url;
	}
	
	//모임 작성 폼에 적은 모임 등록
	@PostMapping("/meeting/form")
	public String meetingWrite(Meeting meeting , @RequestParam(required = false) Preference preference, HttpSession session ) {
		
		logger.info("/meeting/form [POST]");
		
		//알림기능 추가개발예정 
		
		//선호하는 타입에 null이들어가면 preference 객체를 새로 생성  
		if(preference == null) {
			preference = new Preference();
		}
		
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
		meeting.setUserno(meetingService.getUserno(userno));
		
		
		meetingService.inputMeeting(meeting , preference);
		
		logger.info("{}" , preference);
		
		logger.info("{}" , meeting);
		
		return "redirect: /meeting/meetinglist";
	}
	
	@GetMapping("/meeting/meetinglist")
	public void allMeetingList(Model model ) {
		
		logger.info("/meeting/meetinglist [GET]" );
		
		List<Meeting> meetinglist = meetingService.getMeetinglistAll();
		
		model.addAttribute("meetinglist" , meetinglist);
		
	}
	
	@GetMapping("/meeting/view")
	public void meetingDetail(Model model, Meeting meeting) {
		
		logger.info("/meeting/view [GET]");
		
		Meeting viewmeeting = meetingService.detailMeeting(meeting);
		List<Users> applicantnick = meetingService.getUserNickAll(meeting);
		
		logger.info("{}" , viewmeeting);
		logger.info("{}!!!!", applicantnick);

		model.addAttribute("viewmeeting", viewmeeting);
		model.addAttribute("applicantnick", applicantnick);
		
		
	}
	
	@GetMapping("/meeting/report")
	public String reportForm(Model model, Meeting viewMeeting) {
		
		logger.info("/meeting/report [GET]");
		
		model.addAttribute("viewmeeting" ,  viewMeeting);
		
		return "/meeting/report";
	}
	
	
	@PostMapping("/meeting/report")
	public void reportInput( ReportMeeting reportMeeting, HttpSession session) {
		
		logger.info("/meeting/report [POST]");
		
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
		reportMeeting.setUserno(meetingService.getUserno(userno));
		
		
		meetingService.inputReportMeeting(reportMeeting);
		
		
	}
	
	@GetMapping("/meeting/applicant")
	public void meetingApplicant(Users users , Applicant applicant , Model model) {
		
		logger.info("/meeting/applicant [GET]"); 
		
		Users applicantuser = meetingService.getMeetingApplicantUser(users);
		Applicant applicantview = meetingService.getMeetingApplicant(applicant);
		
		logger.info("{}" , applicantview);
		
		model.addAttribute("applicantuser" , applicantuser);
		model.addAttribute("applicantview" , applicantview);
	}
	
	
	
	@GetMapping("/meeting/join")
	public void joinMeetingComment(Meeting viewmeeting, Model model, HttpSession session ,Users users) {
		
		logger.info("/meeting/join [GET]");
		
		model.addAttribute("viewmeeting" , viewmeeting);
		
		
	}
	
	@PostMapping("/meeting/join")
	public void meetingJoinInput(HttpSession session, Model model , Applicant applicant) {
		
		logger.info("/meeting/join [POST]");
		
		int userno = (int)session.getAttribute("userno");
		applicant.setUserno(meetingService.getUserno(userno));
		
		meetingService.inputJoinMeeting(applicant);
		
	}
	
	
}
