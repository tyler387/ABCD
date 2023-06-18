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
import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.dto.ItemQnAA;
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
	// 	해결법 1. DTO자체를 배열로 만들어 받기
	//	해결법 2. 리스트로 받아지는 옵션에 대한 멤버필드마다 배열로 선언해 받기
	
	//1번 해결법은 에러가 발생 - 느낌이 이미 멥퍼에 itemOption이 DTO로 되어 있는데 
	// 멥퍼의 파라미터 타입에서 안받아주는 것으로보임... 스프링이 만능이 아니기에 문제가 발생할 여지가
	// 충분했다고 생각함
	
	//그래서 후자의 방법을 사용하려고함
	@PostMapping("/itemview/write")
	public String itemWrite(
			Item itemParam
			,String[] optionContent
			,int[] optionCount
			,int[] extraCharge 
			, MultipartFile[] file
//			,HttpSession session
			,Model model
			) {

		//추가되는 메서드 - 관리자가 한명만 존재한다는 가정하게 사용...userno가 필요가 없어짐
//		itemParam = itemService.mergeParamSession(itemParam, session);

		//매개변수 정보 확인
		logger.info("itemParam1: {}", itemParam);
		
		//ItemOption관련 배열로 받은 멤버 필드를 DTO에 넣기
		List<ItemOption> itemOptionParam =itemService.getItemOptionParam(optionContent, optionCount, extraCharge);
		logger.info("itemOptionParam2: {}", itemOptionParam);
		
		//item, item_option, item_file의 write가 한번에 진행되어야 함
		//생각해보니 파일의 첨부가 필요하지 않아보임...;;
		int registeredItemno = itemService.writeItem(itemParam, itemOptionParam ,file);
		
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
		
		logger.info("범인인가?1");
		List<Map<String, Object>> itemList = itemService.showItemListAll(paging);
		logger.info("itemList: {}", itemList);
		
		model.addAttribute("paging", paging);
		logger.info("범인인가?1");
		model.addAttribute("itemList", itemList);
		
		return "admin/item/itemview/list";
	}

	@GetMapping("/itemview/filter")
	public String itemFilter(
			@RequestParam Map<String, String> filterMap
			, Model model
			,String curPage
			){
		
		logger.info("filterMap1: {}", filterMap);
		
		Paging filterPaging = itemService.getItemFilterPaging(filterMap, curPage);
		
		List<Map<String, Object>> filterItemList = itemService.showItemListByFilter(filterPaging , filterMap);
	
		model.addAttribute("filterListStatus", true);
		model.addAttribute("filterList", true);
		model.addAttribute("filter", filterMap);
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
			,Model model
			) {
		
		//item, item_option, item_file의 SELECT가 한번에 진행되어야 함 
		Map<String, Object> allItemDetail = itemService.showItemDetail(itemno);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("allItemDetail",allItemDetail);
	}
	
	@PostMapping("/itemview/update")
	public String itemRevise(
			Item itemParam
			,String[] optionContent
			,int[] optionCount
			,int[] extraCharge 
			,@RequestParam("file") MultipartFile[] itemFileParam
			,String curPage
			) {

		//ItemOption관련 배열로 받은 멤버 필드를 DTO에 넣기
		List<ItemOption> itemOptionParam =itemService.getItemOptionParam(optionContent, optionCount, extraCharge);
		logger.info("itemOptionParam3: {}", itemOptionParam);

		logger.info("itemParam: {}", itemParam);
		logger.info("itemFileParam: {}", itemFileParam);
		
		
		//item, item_option, item_file의 revise가 한번에 진행되어야 함 
		itemService.reviseItem(itemParam, itemOptionParam, itemFileParam);
		
		return "redirect:./list?curPage=" + curPage;
	}
	
	@GetMapping("/itemview/delete")
	public String itemErase(
			int itemno
			,String curPage
			) {
		
		//item, item_option, item_file의 erase가 한번에 진행되어야 함 
		itemService.eraseItem(itemno);
		
		return "redirect:./list?curPage=" + curPage;
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
	
	@GetMapping("/itemqna/filter")
	public void itemQnAQFilter(
			@RequestParam Map<String, String> filterMap
			,Model model
			,String curPage
			){
		
		logger.info("filterMap22: {}", filterMap);
		Paging paging = itemQnAQService.getItemQnAQFilterPaging(filterMap, curPage);
		
		logger.info("paging: {}", paging);
		List<Map<String, Object>> filteredItemQnAQList =itemQnAQService.showItemQnAQListByFilter(paging, filterMap);

		model.addAttribute("filterListStatus", true);
		model.addAttribute("filterList", true);
		model.addAttribute("filter", filterMap);
		model.addAttribute("itemQnAQList", filteredItemQnAQList);
		model.addAttribute("paging", paging);
	}
	
	@GetMapping("/itemqna/write")
	public void itemQnAAWritePage(
			int itemQnano
			,HttpSession session
			,Model model
			,String curPage
			) {
		logger.info("map: {}", itemQnAQService.showItemQnAQDetail(itemQnano));
		model.addAttribute("curPage",curPage);
		model.addAttribute("qnAQDetail",itemQnAQService.showItemQnAQDetail(itemQnano));
		model.addAttribute("userno",(Integer)session.getAttribute("userno"));
	}
	
	//판매 상품 신규 등록 시 내용글중 파일을 저장한다 - summernote
	@PostMapping(value ="/itemview/writeFileupload" , produces = "application/json; charset=utf8")
	public @ResponseBody JSONObject itemContentFileupload(
//			@RequestParam("files") MultipartFile multipartFile
			@RequestParam("file") MultipartFile file
			) {

		JSONObject jo = itemService.itemContentPic(file);
		
		logger.info(jo.toString());
		
		//*** 응답으로 image url 필요 [ex. /upload/저장파일명]
		return jo; 
	}
	
	@PostMapping("/itemqna/write")
	public String itemQnAAWrite(
			ItemQnAA itemQnAAParam,
			String curPage,
			HttpSession session
			) {
		logger.info("itemQnAAParam:{}", itemQnAAParam);
		logger.info("userno:{}", (Integer)session.getAttribute("userno"));
		itemQnAAParam = itemQnAAService.getCompleteItemQnAA(itemQnAAParam,session);
		
		itemQnAAService.writeItemQnAA(itemQnAAParam);
		
		return "redirect:./list?curPage="+curPage;
	}
	
	@GetMapping("/itemqna/update")
	public void itemQnAARevisePage(
			//버튼을 통해 전달될 mgrItemno와 itemQnano
			ItemQnAA itemQnAAParam
			,Model model
			//보고있던 리스트로 이동시켜줄 현재 페이지
			,String curPage
			) {
		
		model.addAttribute("curPage",curPage);
		model.addAttribute("itemQnAQADetail", itemQnAAService.showItemQnAAllDetail(itemQnAAParam));
		
	}
	
	@PostMapping("/itemqna/update")
	public String itemQnAARevise(
			String curPage,
			ItemQnAA itemQnAAParam
			) {
		itemQnAAService.reviseItemQnAA(itemQnAAParam);
		return "redirect:./list?curPage=" + curPage;
	}
	
	@GetMapping("/itemqna/delete")
	public String itemQnAAErase(
			ItemQnAA itemQnAAParam
			//보고있던 리스트로 이동시켜줄 현재 페이지
			,String curPage
			) {
		itemQnAAService.eraseItemQnAA(itemQnAAParam);
		return "redirect:./list?curPage=" + curPage;
	}
}
