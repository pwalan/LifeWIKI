package service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import dao.FriendsDao;
import dao.UpRecordsDao;
import dao.UserDao;
import domain.Friends;
import domain.UpRecords;
import domain.User;

public class GetThings extends ActionSupport{
	
	private String message;
	
	private String wode;
	
	private int uid=0;
	
	private String things;
	
	private UpRecordsDao upRecordsDao;
	
	private FriendsDao friendsDao;
	
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
	
	/**
	 * 得到所有的上传和我关注的人的上传
	 */
	public String getPengyouquan(){
		setUid(getUid());
		
        jsons = new JSONArray();
		
		List<UpRecords> listUpRecords = upRecordsDao.queryAll();
		
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
		
		if(uid==0){
			setWode("-1");
			return SUCCESS;
		}
		
		jsons = new JSONArray();
		List<Friends> lf=friendsDao.queryByUid(uid);
		if(lf.size() == 0) {
			setWode("-1");
		}else{
			for(int i=0;i<lf.size();i++){
				listUpRecords = upRecordsDao.queryByUid(lf.get(i).getFid());
				for(int j = 0; j < listUpRecords.size(); j++) {
					JSONObject jsonObject = new JSONObject();
					
					//获取用户名
					List<User> userlist = userDao.queryByID(listUpRecords.get(i).getUid());
					jsonObject.put("username", userlist.get(0).getUsername());
					jsonObject.put("uid", listUpRecords.get(j).getUid());
					jsonObject.put("img", listUpRecords.get(j).getImg());
					jsonObject.put("video", listUpRecords.get(j).getVideo());
					
					jsons.add(jsonObject);
				}
			}
			setWode(jsons.toString());
		}
		
		return "success";
	}
	
	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getWode() {
		return wode;
	}

	public void setWode(String wode) {
		this.wode = wode;
	}

}
