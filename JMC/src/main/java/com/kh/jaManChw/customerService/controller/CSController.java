package com.kh.jaManChw.customerService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.customerService.service.face.CSService;

@Controller
@RequestMapping("/cs")
public class CSController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private CSService cSService;
	
	//고객센터 접속시 공지사항 페이지를 보여준다
	//물론 공지사항 버튼을 누를 때도 공지사항 페이지를 보여준다
	@GetMapping("/notice")
	public void cSNoticePage() {
		//공지사항 리스트를 가져온다
	}
	
	//공지사항 글을 선택했을때 공지사항의 상세정보를 보여준다
	@PostMapping("/notice")
	public String cSNoticeDetail() {
		//선택한 공지사항의 상세정보를 보여준다
		
		return null;
	}
	
	//이벤트 버튼을 누르면 이벤트 페이지를 보여준다
	@GetMapping("/event")
	public void cSEventPage() {
		//이벤트 리스트를 가져온다
	}
	
	@PostMapping("/event")
	public String cSEventDetail() {
		//선택한 이벤트 글의 상세정보를 보여준다
		
		return null;
	}
	
	@GetMapping("/qnaQ")
	public void cSQnAQPage() {
		//
	}
	
	@PostMapping("/qnaQ")
	public String cSQnAQWrite() {
		
		return null;
	}
	
}
