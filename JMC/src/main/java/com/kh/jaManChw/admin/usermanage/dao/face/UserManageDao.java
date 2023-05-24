package com.kh.jaManChw.admin.usermanage.dao.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

public interface UserManageDao {

	public List<Users> selectUserMgPage(Paging paging);

	public List<Users> selectUserMgFiltering(Map<String, String> map);

	public int selectCntAll();

}
