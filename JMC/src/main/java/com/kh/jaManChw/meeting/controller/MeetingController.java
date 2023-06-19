package com.kh.jaManChw.meeting.controller;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.ProfileFile;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.service.face.MeetingService;



@Controller
public class MeetingController {
	
@Autowired MeetingService meetingService;
	
@Autowired
ServletContext context;
private final Logger logger = LoggerFactory.getLogger(MeetingController.class);

	//모임 작성 폼으로 이동 
	@GetMapping("/meeting/form")
	public String meetingWriteForm(Meeting meeting , Model model, HttpSession session) {

		logger.info("/meeting/form [GET]");
		
		String url = "";
		
		//로그인이 되어있지 않으면 로그인창으로 return 
		if((session.getAttribute("login")==null)) {
			
			return "redirect: /login/login";
		
		//로그인이 되어있으면 모임 작성 폼으로 이동 
		} else {  
			
			url = "/meeting/form";
		}
		
		//세션에서 사용자 userno값 가져와서 userno에 넣기 
		int userno = (int)session.getAttribute("userno");
		meeting.setUserno(meetingService.getUserno(userno));
		
		logger.info("{}!!!" , userno);
		
	

		//로그인 세션 처리 
		return url;
	}
	
	//모임 작성 폼에 적은 모임 등록
	@PostMapping("/meeting/form")
	public String meetingWrite(Meeting meeting , Preference preference, HttpSession session) {
			
		logger.info("/meeting/form [POST]");
		logger.info("check!!!!!!!!!!!{}" , preference);
		//알림기능 추가개발예정 
		
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
		meeting.setUserno(meetingService.getUserno(userno));
		
		//모임 개설자 정보 가져와서 넣어주기  
		Applicant leader = new Applicant(); 
		
		leader.setUserno(userno);
		
		
		// preference값이 null인 경우에만 새로운 Prefrence 객체 생성 
		if(preference == null) {
			preference = new Preference();
		}
		
		logger.info("!!!!!!!!!!!!1{}" , preference);
		
		//모임과 선호하는타입, 참가자와, 모임 등록자 등록 
		meetingService.inputMeeting(meeting , preference, leader);
		
		
		logger.info("{}" , preference);
		
		logger.info("{}" , meeting);
		
		return "redirect: /meeting/meetingcal";
	}
	
	//달력으로 모든 모임 조회 
	@GetMapping("/meeting/meetingcal")
	public void allMeetingListByCal(Model model , Meeting meeting ) {
		
		
		logger.info("/meeting/meetingcal [GET]" );
		
		//전체 모임 목록 가져오기 
		List<Meeting> meetinglist = meetingService.getMeetinglistAll(meeting);
		
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
	public void allMeetingListByMap(Model model, Meeting meeting, Applicant applicant ) {
		
		logger.info("/meeting/meetingmap [GET]" );
		
		
		//전체 모임 목록 가져오기 
		List<Meeting> meetinglist = meetingService.getMeetinglistAll(meeting);
		
		//등록된 총 모임 수 가져오기 
		int meetingcount = meetingService.getMeetinglistcount(meeting);
		
		//현재 모집중인 모임 수 가져오기 
		int meetingcountnow = meetingService.getMeetinglistcountnow(meeting);
		logger.info("{}" , meetinglist);
		
		model.addAttribute("meetinglist", meetinglist);
		model.addAttribute("meetingcount", meetingcount);
		model.addAttribute("meetingcountnow", meetingcountnow);
		
	}
	
	
	//지도에서 선택해서 AJAX로 선택한 위치의 모임만 조회 
	@GetMapping("/meeting/meetingmapajax")
	public String meetingMap(Meeting meeting,@RequestParam String mapData, String mapData1, Model model) {
		
		logger.info("mapdata{}",mapData);
		logger.info("mapdata1{}",mapData1);
		
		mapData1 = mapData1.replaceAll("\"", "");
			
		mapData = mapData.replaceAll("\"", "");

		logger.info("map!!!{}" , mapData);
		logger.info("map!!!{}" , meeting);
		
		//지도에 찍히는 위치에 해당하는 모임 정보 가져오기 
		List<Meeting> maplist = meetingService.getMeetingListByMap(mapData,mapData1);
		
		//우리의 노력
//		mapData = new HashMap<String, Object>();
//		map.put(loc, coords_x);
		
		model.addAttribute("meetinglist" , maplist);
		
		return "meeting/meetinglist";
	}
	
	//달력에서 선택해서 AJAX로 선택한 날짜의 모임만 조회 
	@GetMapping("/meeting/meetinglist")
	public String meetingCal(Meeting meeting, String data, String data1, String data2, Model model) {
		
		//월수가 10이하일때 앞에 0붙이기
		if(data1.length()==1) {
			data1 = "0"+data1;
		}
		
		//일수가 10이하일때 앞에 0붙이기
		if(data2.length()==1) {
			data2 = "0"+data2;
		}
		
		//날짜 형식 맞추기 
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
		
		//날짜에 맞는 모임목록 가져오기 	
		List<Meeting> list = meetingService.getMeetingListByDate(result);
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
		
		//맵에 요금, 인원수 삽입 
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("fee", fee);
			map.put("headCount" , headcount);
	
			
		logger.info("map!!{}" , map);
		
		//필터에 맞는 모임목록 가져오기 
		List<Meeting> meetingfilter = meetingService.getMeetingListByFilter(map);
		
		model.addAttribute("meetinglist", meetingfilter);
		
		return "/meeting/meetinglist";
	}
	
	//모임 검색
	@GetMapping("/meeting/meetingsearch")
	public String meetingSearch(Meeting meeting, String search, Model model) {
		
		logger.info("search{}", search);
		
		//검색에 맞는 제목의 모임목록 가져오기 
		List<Meeting> searchlist = meetingService.getMeetingListByMname(search);

		model.addAttribute("meetinglist",searchlist);
		return "/meeting/meetinglist";
	}
	
	
	//모임 상세보기 조회 
	@GetMapping("/meeting/view")
	public String meetingDetail(HttpSession session , Model model, Meeting meeting , Preference preference, Applicant applicant,ProfileFile profileFile) {
		
		logger.info("/meeting/view [GET]");
		//파일을 위한 경로 삽입
		String path = context.getRealPath("");
		logger.info("123123{}",path);
		String url = "";
		
		//로그인 세션 검사
		if((session.getAttribute("login")==null)) {
			
			return "redirect: /login/login";
			
		} else {  
			
			url = "/meeting/view";
		}
		
		
		
		
		//모임 총원 수
		int appcount = meetingService.getApplicantCount(applicant);
		//모임 확정 인원 수
		int appcountcheck = meetingService.getApplicantCheckCount(applicant);
		//모임 확정안된 신청인원 수 
		int appcountnocheck = meetingService.getApplicantNoCheckCount(applicant);
		//모임 상세정보
		Meeting viewmeeting = meetingService.getDetailMeeting(meeting);
		//모임 선호타입(추가태그)  
		Preference viewpreference = meetingService.getDetailPreference(preference);
		//모임 확정된 신청인원 정보 
		List<Users> applicantnickagree = meetingService.getUserNickAgree(meeting);
		//모임 확정안된 신청인원 정보 
		List<Users> applicantnicknochceck = meetingService.getUserNickNocheck(meeting);
		// 모집자 정보 
		Users applicantnick1 = meetingService.getUserNickLeader(meeting);
		
		//모집자 프로필 가져오기 
		Map<String, Object> maptest = meetingService.getLeaderProfile(applicant);
		
		
		
		
		logger.info("{}" , viewmeeting);
		logger.info("{}!!!!맵확인", maptest);
		
		
		model.addAttribute("appcount", appcount);
		model.addAttribute("appcountcheck", appcountcheck);
		model.addAttribute("appcountnocheck", appcountnocheck);
		model.addAttribute("viewmeeting", viewmeeting);
		model.addAttribute("viewpreference", viewpreference);
		model.addAttribute("applicantnickagree", applicantnickagree);
		model.addAttribute("applicantnicknocheck", applicantnicknochceck);
		model.addAttribute("applicantnick1", applicantnick1);
		model.addAttribute("maptest" , maptest);
		
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
	public String reportInput(Meeting meeting,  Report reportMeeting, HttpSession session, Model model) {
		
		logger.info("/meeting/report [POST]");
		
		//신고할 모임의 meetingno 가져오기 
		int meetingno = reportMeeting.getMeetingno();
		//세션에서 신고하는 사람의 userno 가져오기 
		int userno = (int)session.getAttribute("userno");
		System.out.println(userno);
		
		//신고자 정보 가져오기 
		reportMeeting.setUserno(meetingService.getUserno(userno));
		
		//reportmeeting에 신고 추가하기  
		
		Users applicantLeader = meetingService.getUserNickLeader(meeting);
		
		if(applicantLeader.getUserno()!=(int)session.getAttribute("userno")) {
			
			meetingService.inputReportMeeting(reportMeeting); 
			
			} else { 
					String url = "/meeting/view?meetingno="+ meetingno;
					String message = "내가 등록한 모임입니다.";
					model.addAttribute("message",message);
					model.addAttribute("url",url);
					return "./layout/alert";
					
					
				}
				
		
		
		
		
		
		return "redirect: /meeting/view?meetingno="+ meetingno;
	}
	
	//선택한 모임의 참여자 정보 조회하기 
	@GetMapping("/meeting/applicant")
	public void meetingApplicant(Users users , Applicant applicant , Model model) {
		
		logger.info("/meeting/applicant [GET]"); 
		
		//모임의 참여자 정보 가져오기 
		Users applicantuser = meetingService.getMeetingApplicantUser(users);
		
		
		Calendar birthCalendar = Calendar.getInstance();
		
		//참여자의 생일로 날짜 저장 
		birthCalendar.setTime(applicantuser.getBirth());
		
		Calendar currentCalendar = Calendar.getInstance();
		
		//현재시간에서 참여자의 생일을 뺴고 년수 가져오기 
		int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
		
		logger.info("!!!!!{}" , age);
		
		
		model.addAttribute("applicantuser" , applicantuser);
		model.addAttribute("age" , age);
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
	public String meetingJoinInput(Meeting meeting ,HttpSession session, Model model , Applicant applicant ) {
		logger.info("/meeting/join [POST]");
		
		//참여할 모임 정보 가져오기 
		int meetingno = applicant.getMeetingno();
		
		//세션에서 참여자 정보 가져오기 
		int userno = (int)session.getAttribute("userno");
		

		logger.info("meetingno{}" , meetingno);
		logger.info("applicant{}" , applicant);
		
		//신청자에 세션에서 가져온 참여자 정보 저장 
		applicant.setUserno(meetingService.getUserno(userno));
		
		Users applicantLeader = meetingService.getUserNickLeader(meeting);
		
		logger.info("leader{}" , applicantLeader);
		
		//신청자가 참여한 횟수 가져오기 
		int chk = meetingService.chkUser(applicant);
		
		logger.info("chk{}" , chk);
		
		if(chk>=1) {
			
			String url = "/meeting/view?meetingno="+ meetingno;
			String message = "이미신청하거나 거절당한 모임입니다.";
			model.addAttribute("message",message);
			model.addAttribute("url",url);
			return "./layout/alert";
			
			
		}else {
		
		//신청 버튼 여러번 못눌리게 딜레이 주기 
		int delay = 3000;
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
		
		//모임에 참여자 정보 등록하기 
		if(applicantLeader.getUserno() != (int)session.getAttribute("userno")) {
			
			
			//모임에 참여하기
			meetingService.inputJoinMeeting(applicant);
			
			
		} else { 
			String url = "/meeting/view?meetingno="+ meetingno;
			String message = "내가 등록한 모임입니다.";
			model.addAttribute("message",message);
			model.addAttribute("url",url);
			return "./layout/alert";
			
			
		}
		

	
		return "redirect: /meeting/view?meetingno="+ meetingno;
		
	}
	

}
