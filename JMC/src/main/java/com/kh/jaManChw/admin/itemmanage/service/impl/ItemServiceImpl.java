package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jaManChw.admin.itemmanage.dao.face.ItemDao;
import com.kh.jaManChw.admin.itemmanage.service.face.ItemService;
import com.kh.jaManChw.dto.Item;
import com.kh.jaManChw.dto.ItemFile;
import com.kh.jaManChw.dto.ItemOption;
import com.kh.jaManChw.util.Paging;

@Service
public class ItemServiceImpl implements ItemService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private ItemDao itemDao;
	@Autowired private ServletContext context;
	
	@Override
	public List<ItemOption> getItemOptionParam(String[] optionContent, int[] optionCount, int[] extraCharge) {

		if (optionContent != null && optionCount != null && extraCharge != null) {
			
			List<ItemOption> itemParamMap = new ArrayList<>();
			for (int i = 0; i< optionContent.length; i++) {
				ItemOption itemOption = new ItemOption();
				itemOption.setOptionContent(optionContent[i]);
				itemOption.setOptionCount(optionCount[i]);
				itemOption.setExtraCharge(extraCharge[i]);
				
				itemParamMap.add(itemOption);
			}
		
			return itemParamMap;
		}
		return null;
	}
	
	@Override
	public JSONObject itemContentPic(MultipartFile file) {

		JSONObject jsonObject = new JSONObject();
		
		if(file.getSize()<=0) {
			return null;
		}
		
		File storedFolder = new File(context.getRealPath("itemContentFile"));
		storedFolder.mkdir();
		
		File dest = null;
		String storedFileName = null;
		
		do {
			storedFileName = UUID.randomUUID().toString().split("-")[4]+UUID.randomUUID().toString().split("-")[0];
			dest = new File(storedFolder, storedFileName);
		} while (dest.exists());
		
		try {
			file.transferTo(dest);
			
			jsonObject.put("url", "/"+ "itemContentFile" +"/"+storedFileName);
			jsonObject.put("responseCode", "success");
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			jsonObject.put("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	@Override
	public int writeItem(Item itemParam, List<ItemOption> itemOptionParam , MultipartFile[] file) {

		
		//itemno 생성
		int itemno = itemDao.getItemno();
		
		logger.info("itemno: {}",itemno);
		
		//itemParam에 담긴 정보를 각 DTO로 분리해 저장한다
		// 1. item DTO
		Item item = new Item();
		item.setItemno(itemno);
		item.setItemTitle(itemParam.getItemTitle());
		item.setAllItemCount(itemParam.getAllItemCount());
		item.setItemType(itemParam.getItemType());
		item.setItemStatus(itemParam.getItemStatus());
		item.setItemPrice(itemParam.getItemPrice());
		item.setItemContent(itemParam.getItemContent());		
		
		//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
		itemDao.insertItem(item);

		if (itemOptionParam !=null) {
			for(ItemOption io : itemOptionParam) {
				
				// 2. itemOption DTO - 만약 옵션값을 넣는다면...
				io.setItemno(itemno);
				itemDao.insertItemOption(io);
			}
		}
		
		// 3. itemFile DTO
		ItemFile itemFile = new ItemFile();
		itemFile.setItemno(itemno);
		
		for (MultipartFile mf : file) {
			if(mf.getSize()<=0) {
				return 0;
			}
		}
		
		for (MultipartFile mfile : file) {
			
			String storedPath = context.getRealPath("itemfile");
			File storedFolder = new File(storedPath);
			storedFolder.mkdir();
			
			File dest = null;
			String storedFileName = null;
			
			do {
				storedFileName = UUID.randomUUID().toString().split("-")[4]+UUID.randomUUID().toString().split("-")[0];
				dest = new File(storedFolder, storedFileName);
			}while(dest.exists());
			
			
			
			try {
				mfile.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			itemFile.setiOriginName(mfile.getOriginalFilename());
			itemFile.setiStoredName(storedFileName);
			itemFile.setFilesize(mfile.getSize());
			
			//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
			itemDao.insertItemFile(itemFile);
			
		}
		
		logger.info("item: {}",item);
		logger.info("itemOption: {}",itemOptionParam);
		logger.info("itemFile: {}",itemFile);
		
		
		return itemno;
	}
	
	@Override
	public Paging getItemPaging(String curPage) {

		int itemCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemCurPage = Integer.parseInt(curPage);
		}
		
		return new Paging(itemCurPage, itemDao.selectCntAllItem());
	}
	
	@Override
	public List<Map<String, Object>> showItemListAll(Paging paging) {
		return itemDao.selectItemAll(paging);
	}
	
	@Override
	public Paging getItemFilterPaging(Map<String, String> filterMap, String curPage) {
		
		int itemCurPage = 0;
		
		if (curPage != null && !"".equals(curPage)) {
			itemCurPage = Integer.parseInt(curPage);
		}
		
		logger.info("filterMap:{}", filterMap);
		
		return new Paging(itemCurPage, itemDao.selectCntFilterItem(filterMap));
	}
	
	@Override
	public List<Map<String, Object>> showItemListByFilter(Paging itemFilterPaging, Map<String, String> filterMap) {
		
		//필터링 맵과 페이징 객체를 같이 가져가기 위한 맵 선언
		Map<String, Object> fpMap = new HashMap<>();
		
		fpMap.put("paging", itemFilterPaging);
		fpMap.put("filter", filterMap);
		
		return itemDao.selectItemByFilter(fpMap);
	}
	
	@Override
	public Map<String, Object> showItemDetail(int itemno) {

		//itemno를 통해  item, itemOption, itemFile테이블을 조회한다 
		//itemOption가 itemFile은 Detail이라도 하더라도 다수의 row가 존재할수 있기에
		//join하기엔 적합하지 않다고 판단이 되나, 분리하여 반환하는 경우는 
		//반환값이 여러개가 존재하게 하거나 List로 담아서 반환하는데 
		//List내부에서 item을 어느 map에 담은지 확인이 불가능하기에
		//모든 맵에 item의 정보를 가지고 있으나 그중 하나만 사용하고 
		//List는 option과 file을 위해서 만사용하는 방법을 사용하려고 한다
		
		//다시 조정..! 각자에 맞는 List<DTO>를 맵으로 넣자!
		List<ItemOption> itemOptionDetailList = itemDao.selectItemOptionDetail(itemno);
		List<ItemFile> itemFileDetailList = itemDao.selectItemFileDetail(itemno);
		Item itemDetail = itemDao.selectItemDetail(itemno);
		
		Map<String, Object> allDetailMap = new HashMap<>();
		
		allDetailMap.put("itemDetail", itemDetail);
		allDetailMap.put("itemOptionDetail", itemOptionDetailList);
		allDetailMap.put("itemFileDetail", itemFileDetailList);
		
		return allDetailMap;
		
	}
	
	@Override
	public void reviseItem(Item itemParam, List<ItemOption> itemOptionParam, MultipartFile[] itemFileParam) {
		
		//item 테이블을 수정한다
		itemDao.updateItem(itemParam);
		
		//itemOption 테이블을 수정한다 - itemno는 item DTO에서 가져와서 사용한다
		if (itemOptionParam != null) {

			//1. 기존의 itemOption정보를 삭제한다
			itemDao.deleteItemOption(itemParam.getItemno());
			
			for(ItemOption io : itemOptionParam) {
				io.setItemno(itemParam.getItemno());
				itemDao.insertItemOption(io);
			}
		}
		
		//itemFile 테이블을 수정한다 - itemno는 item DTO에서 가져와서 사용한다

		//파일이 존재하는지 확인
		logger.info("파일이 존재하는가? : {}", itemFileParam != null);
		
		
		if (itemFileParam != null) {
			//1. itemFile에 파일이 담겨있다면 item DTO의 itemno를 통해 
			//	 기존 파일의 저장된 이름을 가져온다
			List<ItemFile> itemFileInfo = itemDao.selectItemFileDetail(itemParam.getItemno());
		
			//2. itemFile에 파일이 담겨있다면 기존의 파일을 삭제한다
		
			//해당 파일의 실제 경로를 찾아 파일 객체를 생성한다
			File storedFile =  null;
			
			
			//파일객체를 통해서 iStoredName과 동일한 파일들을 삭제한다
			for (ItemFile ifile : itemFileInfo) {
				storedFile = new File(context.getRealPath("itemfile/")+ifile.getiStoredName());
				storedFile.delete();
			}

			//3. itemFile에 파일이 담겨 있다면 기존의 파일의 정보를 DB에서 삭제한다.
			itemDao.deleteItemFile(itemParam.getItemno());
			
			
			//4. 새롭게 추가된 File을 저장한다
			for(MultipartFile mfile : itemFileParam) {
				
				if (mfile.getSize()<=0) {
					return;
				}
				
				File storedFolder = new File(context.getRealPath("itemfile"));
				storedFolder.mkdir();
				
				File dest = null;
				String newStoredFile = null;
				
				do {
					newStoredFile = UUID.randomUUID().toString().split("-")[4]+UUID.randomUUID().toString().split("-")[0];
					
					dest = new File(storedFolder, newStoredFile);
				} while (dest.exists());
				
				try {
					logger.info("도착했나?");
					logger.info("도착했다면 mfile은 뭐제?: {}", mfile);
					mfile.transferTo(dest);
					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				//5. 새롭게 저장된 file의 정보를 저장한다
				ItemFile itemFile = new ItemFile();
				itemFile.setItemno(itemParam.getItemno());
				itemFile.setiOriginName(mfile.getOriginalFilename());
				itemFile.setiStoredName(newStoredFile);
				itemFile.setFilesize(mfile.getSize());
				
				itemDao.insertItemFile(itemFile);
				
			}
		}
	}
	
	@Override
	public void eraseItem(int itemno) {
		logger.info("제거하라!");
		
		//update로 상태를 변경하려고 했는데 상태라는게 DB항목에 전혀 없네..
		//일단 그냥 delete로 해야할것 같음!!
		
//		//1. itemOption 테이블에 상품 정보 제거
//		itemDao.deleteItemOption(itemno);
//		
//		//2. itemFile 테이블에 상품 정보 제거
//		itemDao.deleteItemFile(itemno);
//		
//		//3. item 테이블에 상품 정보 제거
//		itemDao.deleteItem(itemno);
		
		//item 상태만 변경으로 삭제처리를 한다
		itemDao.updateItemStatus(itemno);
	}
}
