package service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import dao.UpRecordsDao;
import dao.UserDao;
import domain.UpRecords;
import domain.User;

public class GetThings extends ActionSupport{
	
	private String message;
	
	private String things;
	
	private UpRecordsDao upRecordsDao;
	
	private UserDao userDao;

	private JSONArray jsons;

	public String getthings() {
		
		setThings(getThings());
		
		jsons = new JSONArray();
		
		List<UpRecords> listUpRecords = upRecordsDao.queryByKeyword(things);
		
		if(listUpRecords.size() == 0) {
			setMessage("-1");
			return "success";
		}
		
		for(int i = 0; i < listUpRecords.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			
			//获取用户名
			List<User> userlist = userDao.queryByID(listUpRecords.get(i).getUid());
			jsonObject.put("username", userlist.get(0).getUsername());
			jsonObject.put("uid", listUpRecords.get(i).getUid());
			jsonObject.put("img", listUpRecords.get(i).getImg());
			jsonObject.put("video", listUpRecords.get(i).getVideo());
			
			jsons.add(jsonObject);
		}
		
		setMessage(jsons.toString());
		
		return "success";
	}
	
	public UpRecordsDao getUpRecordsDao() {
		return upRecordsDao;
	}

	public void setUpRecordsDao(UpRecordsDao upRecordsDao) {
		this.upRecordsDao = upRecordsDao;
	}

	public void setThings(String things) {
		this.things = things;
	}
	
	public String getThings() {
		return things;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

}
