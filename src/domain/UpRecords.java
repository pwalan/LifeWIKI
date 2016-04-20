package domain;

import java.sql.Date;



/**
 * 上传记录
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:39:21
 */
public class UpRecords {
	//记录id
	private int id;
	//用户id
	private int uid;
	//图片地址
	private String img;
	//视频地址
	private String video;
	//检索字段
	private String keyword;
	//上传成功时间
	private String time;
	//点击量
	private int clickNum;
	
	public UpRecords() {
		super();
	}

	public UpRecords(int uid, String img, String video, String keyword,
			String time, int clickNum) {
		super();
		this.uid = uid;
		this.img = img;
		this.video = video;
		this.keyword = keyword;
		this.time = time;
		this.clickNum = clickNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	
	
}
