package domain;
/**
 * 好友表
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:34:43
 */
public class Friends {
	//流水号
	private int SD;
	//用户id
	private int uid;
	//好友id
	private int fid;
	
	public Friends() {
		super();
	}

	public Friends(int uid, int fid) {
		super();
		this.uid = uid;
		this.fid = fid;
	}

	public int getSD() {
		return SD;
	}

	public void setSD(int sD) {
		SD = sD;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	
	
}
