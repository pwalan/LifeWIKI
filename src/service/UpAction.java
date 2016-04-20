package service;

import java.text.SimpleDateFormat;
import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

import dao.UpRecordsDao;
import domain.UpRecords;

public class UpAction extends ActionSupport{
	private int uid;
	private String img;
	private String video;
	private String keyword;
	private Date time;
	private int clickNum;
	
	private UpRecordsDao upRecordsDao;
	
	public void setUpRecordsDao(UpRecordsDao upRecordsDao) {
		this.upRecordsDao = upRecordsDao;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	
	public String saveUp(){
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = sdf.format(dt);
		
		setUid(getUid());
		setImg(getImg());
		setVideo(getVideo());
		setKeyword(getKeyword());
		System.out.println(uid+":"+img+"+"+video+"+"+keyword+current);

		upRecordsDao.save(new UpRecords(uid,img,video,keyword,current,0));
		
		return SUCCESS;
	}
	
}
