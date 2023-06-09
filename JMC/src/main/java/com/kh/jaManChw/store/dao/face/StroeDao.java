package com.kh.jaManChw.store.dao.face;

import java.util.List;
import java.util.Map;

public interface StroeDao {

	List<Map<String, String>> selectAllShoppingbasketList(int userno);

	void updateSbUpdate(Map<String, String> map);

}
