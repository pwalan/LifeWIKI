package service;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.FriendsDao;
import dao.UpRecordsDao;
import dao.UserDao;
import domain.Friends;
import domain.UpRecords;
import domain.User;

public class GetPersonalInfor extends ActionSupport{
	
	private int userID = -1;
	
	private String username;
	
	private String head;
	
	private String phone;
	
	private String email;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private int pengyouquanNumber;

	private int frientNumber;
	
	private int zanNumber;
	
	private UpRecordsDao upRecordsDao;
	
	private UserDao userDao;
	
	private FriendsDao friendsDao;
	
	public String getInfor() {
		
		setUserID(getUserID());
		System.out.println("userID:" + userID);
		if(userID == -1) {
			setUsername("Guest");
			setPengyouquanNumber(0);
			setFrientNumber(0);
			setZanNumber(0);
			setHead("");
			setPhone("");
			setEmail("");
		} else {
			List<User> userlist = userDao.queryByID(userID);
			if(userlist == null) {
				setUsername("Guest");
				setPengyouquanNumber(0);
				setFrientNumber(0);
				setZanNumber(0);
			} else {
				setUsername(userlist.get(0).getUsername());
				
				//朋友圈number
				List<UpRecords> upRecordslist = upRecordsDao.queryByUid(userID);
				if(upRecordslist == null) {
					setPengyouquanNumber(0);
				} else {
					setPengyouquanNumber(upRecordslist.size());
				}
				
				//好友number
				List<Friends> friendlist = friendsDao.queryByUid(userID);
				if(friendlist == null) {
					setFrientNumber(0);
				} else {
					setFrientNumber(friendlist.size());
				}

				setZanNumber(userlist.get(0).getPublicNum());
				setHead(userlist.get(0).getHead());
				setPhone(userlist.get(0).getPhone());
				setEmail(userlist.get(0).getEmail());
			}
		}
		
		
		return "success";
	}

	public void setUpRecordsDao(UpRecordsDao upRecordsDao) {
		this.upRecordsDao = upRecordsDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	public UpRecordsDao getUpRecordsDao() {
		return upRecordsDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public FriendsDao getFriendsDao() {
		return friendsDao;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPengyouquanNumber() {
		return pengyouquanNumber;
	}

	public void setPengyouquanNumber(int pengyouquanNumber) {
		this.pengyouquanNumber = pengyouquanNumber;
	}

	public int getFrientNumber() {
		return frientNumber;
	}

	public void setFrientNumber(int frientNumber) {
		this.frientNumber = frientNumber;
	}

	public int getZanNumber() {
		return zanNumber;
	}

	public void setZanNumber(int zanNumber) {
		this.zanNumber = zanNumber;
	}


}
