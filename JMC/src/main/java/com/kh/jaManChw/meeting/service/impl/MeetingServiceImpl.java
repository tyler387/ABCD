package com.kh.jaManChw.meeting.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.jaManChw.chat.dao.face.ChatDao;
import com.kh.jaManChw.dto.Applicant;
import com.kh.jaManChw.dto.ChatRoom;
import com.kh.jaManChw.dto.ChatUser;
import com.kh.jaManChw.dto.Meeting;
import com.kh.jaManChw.dto.Preference;
import com.kh.jaManChw.dto.Report;
import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.meeting.controller.MeetingController;
import com.kh.jaManChw.meeting.dao.face.MeetingDao;
import com.kh.jaManChw.meeting.service.face.MeetingService;
import com.kh.jaManChw.util.MeetingPaging;



@Component
public class MeetingServiceImpl implements MeetingService{

	
private final Logger logger = LoggerFactory.getLogger(MeetingController.class);
	
@Autowired MeetingDao meetingDao;	
@Autowired ChatDao chatDao;
	
	
	@Override
	public int getUserno(int userno) {
	
		return meetingDao.selectUserNo(userno);
	}

	@Override
	public void inputMeeting(Meeting meeting, Preference preference, Applicant leader) {
		
		
		int meetingno = meetingDao.selectMeetingno();
		
		meeting.setMeetingno(meetingno);
		
		
		
		meetingDao.insertMeeting(meeting);
		
		preference.setMeetingno(meetingno);
		
		meetingDao.insertPreference(preference);
		
		
		leader.setMeetingno(meetingno);
		
		meetingDao.insertMeetingUser(leader);
		
		int nextChatno = chatDao.selectNextChatno();
		
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setChatno(nextChatno);
		chatRoom.setChatname(meeting.getMname());
		chatRoom.setMeetingno(meetingno);
		chatRoom.setChatcloseday(meeting.getMeetingDate());
		
		chatDao.insertChatRoom(chatRoom);

		ChatUser chatUser = new ChatUser();
		chatUser.setChatno(nextChatno);
		chatUser.setUserno(leader.getUserno());
		chatDao.insertChatUser(chatUser);
		
	}
	
	
	
	@Override
		public List<Meeting> getMeetinglistAll(Meeting meeting) {
		
		meetingDao.updateStatus(meeting);
		
		
		return meetingDao.selectMeetinglistAll();
	}
	
	
	
	@Override
		public Meeting getDetailMeeting(Meeting meeting) {
		
		meetingDao.updatehit(meeting);
		
		return meetingDao.selectMeeting(meeting);
	}
	
	@Override
		public void inputReportMeeting(Report reportMeeting) {		
		
		meetingDao.insertReportMeeting(reportMeeting);
		
	}
	


	@Override
	public List<Users> getUserNickAgree(Meeting meeting) {
		
		return meetingDao.selectUserNickAgree(meeting);
	}
	
	@Override
		public List<Users> getUserNickNocheck(Meeting meeting) {
		
		return meetingDao.selectUserNickNoCheck(meeting);
	}
	
	
	@Override
	public Users getUserNickLeader(Meeting meeting) {
		
		return meetingDao.selectMeetingApplicantLeader(meeting);
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
	public List<Meeting> getMeetingListByDate(String result) {

		
		return meetingDao.selectMeetingListByDate(result);
	}

	@Override
	public List<Meeting> getMeetingListByMap(String mapData, String mapData1) {
		
		return meetingDao.selectMeetingListByMap(mapData,mapData1);
	}
	
	
	@Override
	public int getMeetinglistcount(Meeting meeting) {
		
		return meetingDao.selectMeetingListCount(meeting);
	}
	
	
	@Override
		public List<Meeting> getMeetingListByMname(String search) {
		
			return meetingDao.selectMeetingListByMname(search);
		}
	
	@Override
		public List<Meeting> getMeetingListByFilter(Map<String, Object> map) {
		
			return meetingDao.selectMeetingListByFilter(map);
		}
	

	@Override
		public int getMeetinglistcountnow(Meeting meeting) {
		
			return meetingDao.selectMeetingListCountnow(meeting);
		}
	
	
	@Override
		public Preference getDetailPreference(Preference preference) {
			return meetingDao.selectDetailPreference(preference);
		}
	
	@Override
		public int getMeetingappcount(Meeting meeting) {
		
			return meetingDao.selectMeetingappcount(meeting);
		}

	@Override
		public void updateApplicant(Applicant applicant) {

			meetingDao.updateApplicantAgree(applicant);
			logger.info("testetsetsetset{}",applicant.getAgree());
			logger.info("equestaefseufssdfjsdfk{}",applicant.getAgree().equals("yes"));
			if(applicant.getAgree().equals("yes")) {
				chatDao.insertChatUserAgree(applicant);
			}
		}

	@Override
	public MeetingPaging getPaging(String curPage,HttpSession session) {
		int noCurPage=0;
	      if(curPage !=null && !"".equals(curPage)) {
	         noCurPage = Integer.parseInt(curPage);
	      }
		Meeting meeting = new Meeting();
		meeting.setUserno((int)session.getAttribute("userno"));
		List<Meeting> list = meetingDao.selectMyMeetingno(meeting);
		int totalCount;
		logger.info("list!!@!@!@!@!@!@{}",list);
		if(list.isEmpty()) {
			logger.info("test");
			totalCount = 1;
		}else {
		
		totalCount = meetingDao.selectCnt(list);
		}
		logger.info("totalCount{}",totalCount);
		if(totalCount==0) {
			totalCount = 1;
		}
		MeetingPaging paging = new MeetingPaging(noCurPage, totalCount);
		return paging;
	}
	
	@Override
		public int getApplicantCount(Applicant applicant) {
		
			return meetingDao.selectApplicantCount(applicant);
		}
	
	@Override
		public int getApplicantCheckCount(Applicant applicant) {
		
			return meetingDao.selectApplicantCheckCount(applicant);
		}
	
	@Override
		public int getApplicantNoCheckCount(Applicant applicant) {
		
			return meetingDao.selectApplicantNoCheckCount(applicant);
		}
	
	@Override
		public int chkUser(Applicant applicant) {
			return meetingDao.selectMeetingAppUser(applicant);
		}
	

	@Override
	public List<Map<String, Object>> getApplicantAll(HttpSession session, MeetingPaging paging) {
		Meeting meeting = new Meeting();
		meeting.setUserno((int)session.getAttribute("userno"));
		
		List<Meeting> list = meetingDao.selectMyMeetingno(meeting);
		logger.info("isEmpty{}",list.isEmpty());
		if(list.isEmpty()) {
		return null;
		}else {
		return meetingDao.selectApplicantPaging(list,paging);
		}
	}
	@Override
	public boolean chkHeadCount(Applicant applicant) {
		int chkCount = meetingDao.selectNotFull(applicant);
		if(chkCount == 1) {
			return true;
		}else {
			return false;
			
		}
		
	}
	@Override
		public MeetingPaging getappliPaging(String curPage, HttpSession session) {
		int noCurPage=0;
	      if(curPage !=null && !"".equals(curPage)) {
	         noCurPage = Integer.parseInt(curPage);
	      }
		Meeting meeting = new Meeting();
		meeting.setUserno((int)session.getAttribute("userno"));
		int totalCount = meetingDao.selectCntAll(meeting);
		if(totalCount == 0) {
			totalCount = 1;
		}
		MeetingPaging paging = new MeetingPaging(noCurPage, totalCount);
		return paging;
		}
	@Override
		public List<Map<String, Object>> getMyapplicant(HttpSession session, MeetingPaging paging) {
		
			Applicant applicant = new Applicant();
			applicant.setUserno((int)session.getAttribute("userno"));
			
		return meetingDao.selectMyApplicant(applicant,paging);
		}
	
	@Override
		public MeetingPaging getMyMeetingCount(String curPage, HttpSession session) {
		int noCurPage=0;
	      if(curPage !=null && !"".equals(curPage)) {
	         noCurPage = Integer.parseInt(curPage);
	      }	
			Meeting meeting = new Meeting();
			meeting.setUserno((int)session.getAttribute("userno"));
			int totalCount = meetingDao.selectMyMeetingCntAll(meeting);
			if(totalCount == 0) {
				totalCount = 1;
			}
			MeetingPaging paging = new MeetingPaging(noCurPage, totalCount);
		return paging;
		}
	
		@Override
		public List<Map<String,Object>> getMyMeeting(HttpSession session, MeetingPaging paging) {
			
			Meeting meeting = new Meeting();
			meeting.setUserno((int)session.getAttribute("userno"));
			logger.info("!@#{}",meeting);
			return meetingDao.selectMyMeetingList(meeting,paging);
		}
		@Override
			public Map<String, Object> getLeaderProfile(Applicant applicant) {
				return meetingDao.selectLeaderProfile(applicant);
			}
}
