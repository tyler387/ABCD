package com.kh.jaManChw.admin.itemmanage.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAAService;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemQnAQService;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.dto.QnAA;
import com.kh.jaManChw.util.Paging;

@Controller
@RequestMapping("/admin/item")
public class ItemManageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemService itemService;
	@Autowired private ItemQnAQService itemQnAQService;
	@Autowired private ItemQnAAService itemQnAAService;
	
	@GetMapping("/itemview/write")
	public void itemWritePage() {
	}
	
	// 옵션을 여러개를 받을때 리스트로 받게 될텐데 파라미터를 별개로 옵션을 리스트로 받을 방법이 생각나지 않음..
	
	@PostMapping("/itemview/write")
	public String itemWrite(
			@RequestParam Map<String,String> itemParam
			,@RequestParam(name = {"OptionContent","extraCharge", "optionCount"}) List<ItemOption> itemOptionParam
			, MultipartFile file
//			,HttpSession session
			,Model model
			) {

		//추가되는 메서드 - 관리자가 한명만 존재한다는 가정하게 사용...userno가 필요가 없어짐
//		itemParam = itemService.mergeParamSession(itemParam, session);

		//매개변수 정보 확인
		logger.info("itemParam1: {}", itemParam);
		logger.info("itemOptionParam2: {}", itemOptionParam);
		
		//item, item_option, item_file의 write가 한번에 진행되어야 함
		//생각해보니 파일의 첨부가 필요하지 않아보임...;;
		int registeredItemno = itemService.writeItem(itemParam, file);
		
		if (registeredItemno != 0) {
			model.addAttribute("reqisteredItemno", registeredItemno);
		}

		//view로 보여줄 판매 상품 번호
		logger.info("itemno: {}", registeredItemno);
		
		return "admin/item/itemview/successwritepage";
	}
	
	@PostMapping("/itemview/successwritepage")
	public void registerSuccessPage() {
		
	}
	
	@GetMapping("/itemview/list")
	public String itemReviseErasePage(
			Model model,
			String curPage,
			@RequestParam Map<String, String> itemParam
			) {
		
		//추가되는 메서드 - 페이징을 하는 메서드 - 아래 메서드에서 한번에 호출해서 사용
		Paging paging = itemService.getItemPaging(curPage);
		
		List<Map<String, Object>> itemList = itemService.showItemListAll(paging);
		logger.info("itemList: {}", itemList);
		
		model.addAttribute("paging", paging);
		model.addAttribute("itemList", itemList);
		
		return "admin/item/itemview/list";
	}

	@PostMapping("/itemview/filter")
	public String itemFilter(
			@RequestParam Map<String, String> filterMap
			, Model model
			,String curPage
			){
		
		logger.info("filterMap: {}", filterMap);
		
		Paging filterPaging = itemService.getItemFilterPaging(filterMap, curPage);
		
		List<Map<String, Object>> filterItemList = itemService.showItemListByFilter(filterPaging , filterMap);
	
		model.addAttribute("paging", filterPaging);
		model.addAttribute("itemList", filterItemList);
		
		//forward, redirect를 하지 않고 jsp의 위치로만 사용하면 재사용 쌉가능;
		return "admin/item/itemview/list";
	}
	
	
	@GetMapping("/itemview/update")
	public void itemRevisePage(
			int itemno,
			//반환해줘야할 현재 페이지 값
			String curPage
			) {
		
		//item, item_option, item_file의 SELECT가 한번에 진행되어야 함 
		itemService.showItemDetail(itemno);
	}
	
	@PostMapping("/itemview/update")
	public void itemRevise(
			Map<String, String> itemParam
			
			//보고있던 리스트로 이동시켜줄 현재 페이지
			,String curPage
			) {
		//item, item_option, item_file의 revise가 한번에 진행되어야 함 
		itemService.reviseItem(itemParam);
	}
	
	@GetMapping("/itemview/delete")
	public void itemErase(
			int itemno
			) {
		
		//item, item_option, item_file의 erase가 한번에 진행되어야 함 
		itemService.eraseItem(itemno);
	}
	
	//--------------------------- 아이템 등록/수정/삭제 끝---------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//--------------------------- 아이템 문의 답변 등록/수정/삭제 ---------------------------------
	
	@GetMapping("/itemqna/list")
	public void itemQnAPage(
			String curPage,
			Model model
			) {
		
		Paging paging = itemQnAQService.getItemQnAQPaging(curPage);
		
		List<Map<String, Object>> itemQnAQList = itemQnAQService.showItemQnAQList(itemQnAQService.getItemQnAQPaging(curPage));
		
		model.addAttribute("itemQnAQList", itemQnAQList);
		model.addAttribute("paging", paging);
	}
	
	@PostMapping("/itemqna/filter")
	public void itemQnAQFilter(
			Map<String, String> filterMap
			,Model model
			,String curPage
			){
		
		Paging paging = itemQnAQService.getItemQnAQFilterPaging(filterMap, curPage);
		
		List<Map<String, Object>> filteredItemQnAQList =itemQnAQService.showItemQnAQListByFilter(paging, filterMap);

		model.addAttribute("itemQnAQList", filteredItemQnAQList);
		model.addAttribute("paging", paging);
	}
	
	@GetMapping("/itemqna/write")
	public void itemQnAAWritePage(
			int itemQnano
			,HttpSession session
			,Model model
			) {
		model.addAttribute("qnAQDetail",itemQnAQService.showItemQnAQDetail(itemQnano));
		model.addAttribute("userno",(Integer)session.getAttribute("userno"));
	}
	
	//판매 상품 신규 등록 시 내용글중 파일을 저장한다 - summernote
	@PostMapping(value ="/itemview/writeFileupload" , produces = "application/json; charset=utf8")
	public @ResponseBody JSONObject adminBoardContentFileupload(
//			@RequestParam("files") MultipartFile multipartFile
			@RequestParam("file") MultipartFile multipartFile
			) {

//		JSONObject jo = adminBoardService.manageFile(multipartFile);
		
//		logger.info(jo.toString());
		
		//*** 응답으로 image url 필요 [ex. /upload/저장파일명]
//		return jo; 
		return null; 
	}
	
	@PostMapping("/itemqna/write")
	public void itemQnAAWrite(
			QnAA qnAAParam
			) {
		itemQnAAService.writeItemQnAA(qnAAParam);
	}
	
	@GetMapping("/itemqna/update")
	public void itemQnAARevisePage() {
		
		
	}
	
	@PostMapping("/itemqna/update")
	public void itemQnAARevise(
			//버튼을 통해 전달될 mgrItemno와 itemQnano
			QnAA qnAAParam
			,Model model
			//보고있던 리스트로 이동시켜줄 현재 페이지
			,String curPage
			) {
		model.addAttribute("itemQnAQADetail", itemQnAAService.reviseItemQnAQ(qnAAParam));
		
	}
	
	@PostMapping("/itemqna/delete")
	public void itemQnAAErase(
			int mgrItemno
			//보고있던 리스트로 이동시켜줄 현재 페이지
			,String curPage
			) {
		itemQnAAService.eraseItemQnAQ(mgrItemno);
	}
}
