package com.kh.jaManChw.admin.usermanage.dao.face;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.jaManChw.dto.Users;
import com.kh.jaManChw.util.Paging;

public interface UserManageDao {

	public List<Users> selectUserMgPage(Paging paging);

	public List<Users> selectUserMgFiltering(Map<String, Object> map);

	public int selectCntAll();

	public Map<String, String> getUserdata(int userno);

	public void deleteUserMgWithdraw(int userno);

	public int selectFilterCntAll(Map<String, Object> map);

	public void updateUserBlackUpdate(int userno);

	public void updateUserBlackStop(int userno);

	public void updateUserMgUpdate(Map<String, Object> map);

	public int selectUserProfile(int userno);

	public Map<String, String> getUserdataProfile(int userno);

	
}
