package com.kh.jaManChw.admin.itemmanage.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

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
	public void writeItem(Map<String, String> itemParam, MultipartFile file) {

		
		//itemno 생성
		int itemno = itemDao.getItemno();
		
		logger.info("itemno: {}",itemno);
		
		//itemParam에 담긴 정보를 각 DTO로 분리해 저장한다
		// 1. item DTO
		Item item = new Item();
		item.setItemno(itemno);
		item.setItemTitle(itemParam.get("itemTitle"));
		item.setAllItemCount(Integer.parseInt(itemParam.get("allItemCount")));
		item.setItemType(itemParam.get("itemType"));
		item.setItemPrice(Integer.parseInt(itemParam.get("itemPrice")));
		item.setItemContent(itemParam.get("itemContent"));		
		
		//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
		itemDao.insertItem(item);
		
		ItemOption itemOption = null;
		
		// 2. itemOption DTO - 만약 옵션값을 넣는다면...
		if (itemParam.get("OptionContent")!=null && !"".equals(itemParam.get("OptionContent"))) {
			itemOption = new ItemOption();
			itemOption.setItemno(itemno);
			itemOption.setOptionContent(itemParam.get("OptionContent"));
			itemOption.setOptionCount(Integer.parseInt(itemParam.get("optionCount")));
			itemOption.setExtraCharge(Integer.parseInt(itemParam.get("extraCharge")));
		}
		
		//itemOption이 있는 경우는 itemOption DTO에 담긴 정보를 DB의 item테이블에 저장한다
		if (itemOption != null) {
			itemDao.insertItemOption(itemOption);
		}
		
		// 3. itemFile DTO
		ItemFile itemFile = new ItemFile();
		itemFile.setItemno(itemno);
		
		if(file.getSize()<=0) {
			return;
		}
		
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
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		itemFile.setiOriginName(file.getOriginalFilename());
		itemFile.setiStoredName(storedFileName);
		itemFile.setFilesize(file.getSize());
		
		//item DTO에 담긴 정보를 DB의 item테이블에 저장한다
		itemDao.insertItemFile(itemFile);
		
		logger.info("item: {}",item);
		logger.info("itemOption: {}",itemOption);
		logger.info("itemFile: {}",itemFile);
		
		
	}
	
	@Override
	public Paging getItemPaging(String curPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> shewItemListAll(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Paging getItemFilterPaging(Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> showItemListByFilter(Paging itemFilterPaging, Map<String, String> filterMap) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void showItemDetail(int itemno) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void reviseItem(Map<String, String> itemParam) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void eraseItem(int itemno) {
		// TODO Auto-generated method stub
		
	}
}
