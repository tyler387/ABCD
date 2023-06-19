package com.kh.jaManChw.customerService.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.jaManChw.customerService.service.face.CSService;
import com.kh.jaManChw.dto.QnAQ;
import com.kh.jaManChw.util.Paging;

@Controller
@RequestMapping("/cs")
public class CSController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private CSService cSService;
	
	//고객센터 접속시 공지사항 페이지를 보여준다
	//물론 공지사항 버튼을 누를 때도 공지사항 페이지를 보여준다
	@GetMapping("/notice/list")
	public void cSNoticePage(String curPage, Model model) {
		
		//공지사항에 대한 페이징
		Paging paging = cSService.getNoticePaging(curPage);
		
		//공지사항 리스트를 가져온다
		List<Map<String, Object>> nList =  cSService.showNoticeList(paging);
		
		model.addAttribute("paging", paging);
		logger.info("페이징객체: {}",paging);
		model.addAttribute("nList", nList);
		
	}
	
	//공지사항 글을 선택했을때 공지사항의 상세정보를 보여준다
	@GetMapping("/notice/detail")
	public void cSNoticeDetail(String adminBoardno, String curPage, Model model) {
		
		//선택한 공지사항의 상세정보를 보여준다
		Map<String, Object> nDetail = cSService.showNoticeDetail(Integer.parseInt(adminBoardno));
		model.addAttribute("nDetail",nDetail);
		
	}
	
	//이벤트 버튼을 누르면 이벤트 페이지를 보여준다
	@GetMapping("/event/list")
	public void cSEventPage(String curPage, Model model) {
		
		//이벤트에 대한 페이징
		Paging paging = cSService.getEventPaging(curPage);
		
		//이벤트 리스트를 가져온다
		List<Map<String, Object>> eList =  cSService.showEventList(paging);
		
		model.addAttribute("paging", paging);
		model.addAttribute("eList", eList);
	}
	
	@GetMapping("/event/detail")
	public void cSEventDetail(String adminBoardno,String curPage, Model model) {
		//선택한 이벤트 글의 상세정보를 보여준다
		Map<String, Object> eDetail = cSService.showEventDetail(Integer.parseInt(adminBoardno));
		model.addAttribute("eDetail",eDetail);
		
	}
	
	//Q&A를 선택시 Q&A페이지를 보여준다
	@GetMapping("/qna/list")
	public void cSQnAQPage(String curPage, Model model) {
		
		//Q&A에 대한 페이징
		Paging paging = cSService.getQnAPaging(curPage);
		
		//QnA리스트를 보여준다 - 공개와 비공개를 선택할 필요성이 있음
		//	=> 비공개라면 로그인한 유저번호를 확인하여 상세 정보를 조회할수 있게 해야한다
		List<Map<String, Object>> qnAList =  cSService.showQnAList(paging);
		
		model.addAttribute("paging", paging);
		model.addAttribute("qnAList", qnAList);
	}
	
	//오픈된 Q&A 혹은 비공개된 자신의 Q&A의 이름을 선택시 상세 정보를 조회한다 - 이때 답변이 등록 되어 있다면 답변까지 같이 가져온다
	@GetMapping("/qna/detail")
	public String cSQnAQDetail(String curPage, HttpSession session, Model model, String questionno){
				
		Map<String, Object> qnADetail =  cSService.showQnADetail(Integer.parseInt(questionno));
		Map<String, Object> qnAADetail = new HashMap<>();
		if(cSService.isAnswered(Integer.parseInt(questionno))) {
			qnAADetail =  cSService.showQnAADetail(Integer.parseInt(questionno));
		}
		logger.info("뭡니까 이게 : {}", qnADetail.get("IS_PUBLIC"));
		
		//현재 조회된 게시글이 공개(public)이라면
		if("public".equals(qnADetail.get("IS_PUBLIC"))) {
			logger.info("어디로 들어왔는가1? {}","public".equals(qnADetail.get("IS_PUBLIC")));
			model.addAttribute("qnADetail",qnADetail);
			model.addAttribute("qnAADetail",qnAADetail);
			model.addAttribute("curPage",curPage);
			return "cs/qna/detail";
			
		}else {//현재 조회된 게시글이 비공개(public)라면
			
			if (session.getAttribute("userno") != null && (Integer)session.getAttribute("userno") == ((BigDecimal)qnADetail.get("USERNO")).intValue()) {
//				logger.info("어디로 들어왔는가2? {}",(Integer)session.getAttribute("userno") == qnADetail.get("USERNO"));
				model.addAttribute("qnADetail",qnADetail);
				model.addAttribute("qnAADetail",qnAADetail);
				model.addAttribute("curPage",curPage);
				
				return "cs/qna/detail";
			}else {
//				logger.info("어디로 들어왔는가3? {}",(Integer)session.getAttribute("userno") == qnADetail.get("USERNO"));
				session.setAttribute("isNotYourQnA", true);
				return "redirect:./list?curPage="+curPage;
			}
		}
	}
	
	//QnA 문의를 등록하는 페이지로 이동한다
	@GetMapping("/qna/write")
	public void cSQnAQWritePage(String curPage, Model model) {
		model.addAttribute("curPage", Integer.parseInt(curPage));
	}
	
	//QnA 문의를 등록하고 Q&A페이지로 이동한다
	@PostMapping("/qna/write")
	public String cSQnAQWrite(HttpSession session,int curPage, QnAQ qnAQ) {
	
		//세션을 통해 userno를 삽입한다
		QnAQ completeQnAQ = cSService.getCompleteQnAQ(session,qnAQ);
		
		cSService.writeQnAQ(completeQnAQ);
		return "redirect:./list?curPage="+curPage;
	}
	
	//Q&A 문의를 수정할수 있는 페이지로 이동한다
	@GetMapping("/qna/revise")
	public String cSQnAQRevisePage(String curPage, HttpSession session,String questionno, Model model) {
		Map<String, Object> qnADetail = cSService.showQnADetail(Integer.parseInt(questionno));
		
		int userno = ((BigDecimal)qnADetail.get("USERNO")).intValue();
		int thisUserno = (Integer)session.getAttribute("userno");
		
		if(!"done".equals(qnADetail.get("Q_STATUS"))){
			logger.info("qnADetail: {}", qnADetail);
			logger.info("뭐가 문제지1");
			logger.info("세션 유저값:{}",session.getAttribute("userno").getClass().getName());
			logger.info("세션 유저값:{}",session.getAttribute("userno"));
			logger.info("qnADetail 유저값:{}",qnADetail.get("USERNO").getClass().getName());
			logger.info("qnADetail 유저값:{}",qnADetail.get("USERNO"));
			if (thisUserno == userno) {
				logger.info("뭐가 문제지2");
				model.addAttribute("qnADetail",qnADetail);
				model.addAttribute("curPage",curPage);
				logger.info("뭐가 문제지3");
				return "cs/qna/revise";
				
			}else {
				logger.info("뭐가 문제지5");
				session.setAttribute("isNotUserQnA", true);
				logger.info("뭐가 문제지6");
				return "redirect: ./list?curPage="+curPage;
			}
		}else {
			logger.info("뭐가 문제지7");
			session.setAttribute("isAlreadyAnswered", true);
			logger.info("뭐가 문제지8");
			return "redirect:./list?curPage="+curPage;
		}
		
	}
	
	//QnA 문의를 수정할 정보를 가져와 DB에 수정 한다
	@PostMapping("/qna/revise")
	public String cSQnARevise(String curPage, QnAQ qnAQ) {
		
		cSService.reviseQnAQ(qnAQ);
		
		logger.info("what is cur:{}", curPage);
		return "redirect:./list?curPage=" +curPage;
	}
	
	@GetMapping("/qna/delete")
	public String sCQnAErase(String curPage, String questionno) {
		
		cSService.eraseQnAQ(Integer.parseInt(questionno));
		
		return "redirect:./list?curPage="+curPage;
	}
}
