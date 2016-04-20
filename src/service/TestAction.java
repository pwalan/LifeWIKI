package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.FriendsDao;
import dao.UpRecordsDao;
import dao.UserDao;
import domain.Friends;
import domain.User;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5528119123690441362L;

	private String name;
	
	private String passwd;
	
	private String status;
	
	private String phone;
	
	private int id;
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String userToJson(){
		
		setName(getName());
		setPasswd(getPasswd());
		
		System.out.println(name+" with "+passwd);
		if(name == null || passwd == null) {
			setStatus("fasle");
			setId(0);
		}
		else{
			List<User> userlist=userDao.queryByUserName(name);
			if(userlist==null){
				setStatus("false");
				setId(0);
			}else{
				User user=userlist.get(0);
				if(user.getPassword().equals(passwd)){
					setId(user.getId());
					setStatus("true");
				}
			}
		}
		
        //Map<String, Object> map = new HashMap<String, Object>();
        //User user = new User();
        //user.setID("xiangxiang");
        //List<User> list = new ArrayList<User>();
		//list.add(user);
        //map.put("users", list);
	    //setJsonResult(map);
	    
		System.out.println("userToJson is success finish");
	    return "success";
    }
	
	public String register(){
		setName(getName());
		setPasswd(getPasswd());
		setPhone(getPhone());
		
		System.out.println(name+" with "+passwd+" tel:"+phone);
		
		List<User> userlist=userDao.queryByUserName(name);
		System.out.println(userlist.size());
		if(userlist.size()>0){
			System.out.println("注册失败！");
			setStatus("false");
		}else{
				System.out.println("注册成功！");
				userDao.save(new User(name,passwd,null,phone,null,0));
				setStatus("true");	
		}
		
		return SUCCESS;
	}
	
}
