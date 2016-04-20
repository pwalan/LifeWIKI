package domain;

import java.io.Serializable;

/**
 * 用户信息
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:29:58
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//用户id
	private int id;
	//用户名
	private String username;
	//密码
	private String password;
	//头像地址
	private String head;
	//电话
	private String phone;
	//邮箱
	private String email;
	//点击量
	private int publicNum;

	public User() {
		super();
	}
	
	public User(String username, String password, String head, String phone,
			String email,int publicNum) {
		super();
		this.username = username;
		this.password = password;
		this.head = head;
		this.phone = phone;
		this.email = email;
		this.publicNum = publicNum;
	}

	public void setPublicNum(int publicNum) {
		this.publicNum = publicNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPublicNum() {
		// TODO Auto-generated method stub
		return publicNum;
	}
	
	
}
