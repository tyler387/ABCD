package com.kh.jaManChw.meeting.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import org.springframework.web.servlet.ModelAndView;

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
		
		String url = "";
		
		if((session.getAttribute("login")==null)) {
			
			return "redirect: /login/login";
			
		} else {  
			
			url = "/meeting/form";
		}
		int userno = (int)session.getAttribute("userno");
		meeting.setUserno(meetingService.getUserno(userno));
		
		logger.info("{}!!!" , userno);
		
		//모임 작성 폼에 가져올 친구 목록 조회
		List<Users> friendList = meetingService.selectFriendListAll(userno);
		
		logger.info("{}", friendList);
	
		//모델에 모임 작성 폼에 가져올 친구 목록 담아주기 
		model.addAttribute("friendList", friendList);
		
		//로그인 세션 처리 
		return url;
	}
	
	//모임 작성 폼에 적은 모임 등록
	@PostMapping("/meeting/form")
	public String meetingWrite(Meeting meeting , Preference preference, HttpSession session
	,@RequestParam( name = "friendlist") int friendlist) {
		
		
		//int friends = Integer.parseInt(friend);
		logger.info("testest{}",friendlist);
		logger.info("/meeting/form [POST]");
		logger.info("check!!!!!!!!!!!{}" , preference);
		//알림기능 추가개발예정 
		

		
		
//		선호하는 타입에 null이들어가면 preference 객체를 새로 생성  
		
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
		meeting.setUserno(meetingService.getUserno(userno));
		
		//모임 개설자 정보 가져와서 넣어주기  
		Applicant leader = new Applicant(); 
		
		leader.setUserno(userno);
		
		//친구초대로 초대한 사람 정보 가져와서 넣어주기 
		Applicant applicant = new Applicant();
		
		applicant.setUserno(friendlist);
		
		// preference값이 null인 경우에만 새로운 Prefrence 객체 생성 
		if(preference == null) {
			preference = new Preference();
		}
		
		logger.info("!!!!!!!!!!!!1{}" , preference);
		
		meetingService.inputMeeting(meeting , preference, applicant, leader);
		
		
		
		logger.info("{}" , preference);
		
		logger.info("{}" , meeting);
		
		return "redirect: /meeting/meetingcal";
	}
	
	//달력으로 모든 모임 조회 
	@GetMapping("/meeting/meetingcal")
	public void allMeetingListByCal(Model model , Meeting meeting ) {
		
		logger.info("/meeting/meetingcal [GET]" );
		
		//전체 모임 목록 가져오기 
		List<Meeting> meetinglist = meetingService.getMeetinglistAll();
		
		//전체 모임 개수 가져오기 
		int meetingcount = meetingService.getMeetinglistcount(meeting);
		
		//모집중인 모임 개수 가져오기 
		int meetingcountnow = meetingService.getMeetinglistcountnow(meeting);
		logger.info("count{}" , meetingcount);
		
		model.addAttribute("meetinglist" , meetinglist);
		model.addAttribute("meetingcount", meetingcount);
		model.addAttribute("meetingcountnow" , meetingcountnow);
		
	}
	
	//지도로 모든 모임 조회 
	@GetMapping("/meeting/meetingmap")
	public void allMeetingListByMap(Model model, Meeting meeting) {
		
		logger.info("/meeting/meetingmap [GET]" );
		
		//전체 모임 목록 가져오기 
		List<Meeting> meetinglist = meetingService.getMeetinglistAll();
		
		int meetingcount = meetingService.getMeetinglistcount(meeting);
		
		int meetingcountnow = meetingService.getMeetinglistcountnow(meeting);
		logger.info("{}" , meetinglist);
		
		model.addAttribute("meetinglist", meetinglist);
		model.addAttribute("meetingcount", meetingcount);
		model.addAttribute("meetingcountnow", meetingcountnow);
		
	}
	
	
	//지도에서 선택해서 AJAX로 선택한 날짜의 모임만 조회 
	@GetMapping("/meeting/meetingmapajax")
	public String Meetingmap(Meeting meeting,@RequestParam String mapData, String mapData1, Model model) {
		
		logger.info("mapdata{}",mapData);
		logger.info("mapdata1{}",mapData1);
		
		mapData1 = mapData1.replaceAll("\"", "");
			
		mapData = mapData.replaceAll("\"", "");

		logger.info("map!!!{}" , mapData);
		logger.info("map!!!{}" , meeting);
		
		//지도에 찍히는 위치에 해당하는 모임 정보 가져오기 
		List<Meeting> maplist = meetingService.getMeetingByMap(mapData,mapData1);
		
		//우리의 노력
//		mapData = new HashMap<String, Object>();
//		map.put(loc, coords_x);
		
		model.addAttribute("meetinglist" , maplist);
		
		return "meeting/meetinglist";
	}
	
	//달력에서 선택해서 AJAX로 선택한 날짜의 모임만 조회 
	@GetMapping("/meeting/meetinglist")
	public String Meetingcal(Meeting meeting, String data, String data1, String data2, Model model) {
		
		if(data1.length()==1) {
			data1 = "0"+data1;
		}
		
		if(data2.length()==1) {
			data2 = "0"+data2;
		}
		
		String result = data + "-" + data1 + "-" + data2;
		
		logger.info("meeting{}" , meeting);
		logger.info("date{}" , result);
		
//		Date date = null;
//		SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
//		try {
//			date = simple.parse(result);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		List<Meeting> list = meetingService.getMeetingByDate(result);
//		List<Meeting> list = meetingService.getMeetingByDate(date);
		
		logger.info("list !!{}",list);
		
		//		if(meeting.getMeetingDate())
		
		model.addAttribute("meetinglist", list);
		
		return "meeting/meetinglist";
	}
	
	
	
	//모임 필터
	@GetMapping("/meeting/meetingfilter")
	public String meetingFilter(String fee, String headcount, Meeting meeting, Model model) {
		
		logger.info("fee!!{}", fee);
		logger.info("headCount!!{}", headcount);
		
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("fee", fee);
			map.put("headCount" , headcount);
	
			
		logger.info("map!!{}" , map);
		
		List<Meeting> meetingfilter = meetingService.meetingFilter(map);
		
		model.addAttribute("meetinglist", meetingfilter);
		
		return "/meeting/meetinglist";
	}
	
	//모임 검색하기
	@GetMapping("/meeting/meetingsearch")
	public String meetingSearch(Meeting meeting, String search, Model model) {
		
		logger.info("search{}", search);
		
		List<Meeting> searchlist = meetingService.meetingsearch(search);

		model.addAttribute("meetinglist",searchlist);
		return "/meeting/meetinglist";
	}
	
	
	//모임 상세보기 조회 
	@GetMapping("/meeting/view")
	public String meetingDetail(HttpSession session , Model model, Meeting meeting) {
		
		logger.info("/meeting/view [GET]");
		
		String url = "";
		
		//로그인 세션 검사
		if((session.getAttribute("login")==null)) {
			
			return "redirect: /login/login";
			
		} else {  
			
			url = "/meeting/view";
		}
		
		
		Meeting viewmeeting = meetingService.detailMeeting(meeting);
		List<Users> applicantnick = meetingService.getUserNickAll(meeting);
		Users applicantnick1 = meetingService.getUserNickLeader(meeting);
		
		
		logger.info("{}" , viewmeeting);
		logger.info("{}!!!!", applicantnick);
		
		
		model.addAttribute("viewmeeting", viewmeeting);
		model.addAttribute("applicantnick", applicantnick);
		model.addAttribute("applicantnick1", applicantnick1);
		
		
		
		return url;
	}
	
	//선택한 모임의 신고창 조회 모달창 써서 필요X
//	@GetMapping("/meeting/report")
//	public String reportForm(Model model, Meeting viewMeeting) {
//		
//		logger.info("/meeting/report [GET]");
//		
//		model.addAttribute("viewmeeting" ,  viewMeeting);
//		
//		return "/meeting/report";
//	}
	
	//선택한 모임 신고하기  
	@PostMapping("/meeting/report")
	public String reportInput( ReportMeeting reportMeeting, HttpSession session) {
		
		logger.info("/meeting/report [POST]");
		
		//신고할 모임의 meetingno 가져오기 
		int meetingno = reportMeeting.getMeetingno();
		//세션에서 신고하는 사람의 userno 가져오기 
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
	
		reportMeeting.setUserno(meetingService.getUserno(userno));
		
		//reportmeeting에 신고 추가하기  
		meetingService.inputReportMeeting(reportMeeting);
		
		return "redirect: /meeting/view?meetingno="+ meetingno;
	}
	
	//선택한 모임의 참여자 정보 조회하기 
	@GetMapping("/meeting/applicant")
	public void meetingApplicant(Users users , Applicant applicant , Model model) {
		
		logger.info("/meeting/applicant [GET]"); 
		
		Users applicantuser = meetingService.getMeetingApplicantUser(users);
		Applicant applicantview = meetingService.getMeetingApplicant(applicant);
		
		logger.info("{}" , applicantview);
		
		model.addAttribute("applicantuser" , applicantuser);
		model.addAttribute("applicantview" , applicantview);
	}
	
	
	//선택한 모임의 참여 신청창 조회 모달창써서 필요X
//	@GetMapping("/meeting/join")
//	public void joinMeetingComment(Meeting viewmeeting, Model model, HttpSession session ,Users users) {
//		
//		logger.info("/meeting/join [GET]");
//		
//		model.addAttribute("viewmeeting" , viewmeeting);
//		
//		
//	}
	
	
	//선택한 모임에 참여하기 
	@PostMapping("/meeting/join")
	public String meetingJoinInput(HttpSession session, Model model , Applicant applicant) {
		
		logger.info("/meeting/join [POST]");
		
		int meetingno = applicant.getMeetingno();
		int userno = (int)session.getAttribute("userno");
		applicant.setUserno(meetingService.getUserno(userno));
		
		meetingService.inputJoinMeeting(applicant);
		
		
		return "redirect: /meeting/view?meetingno="+ meetingno;
	}
	
	
}
