package dao;

import java.util.List;

import domain.UpRecords;

/**
 * 对上传记录信息操作的接口
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:58:15
 */
public interface UpRecordsDao {
	/**
	 * 根据用户id得到其上传记录
	 * @param uid
	 * @return 上传记录列表
	 */
	List<UpRecords> queryByUid(int uid);
	
	/**
	 * 根据标签获取到满足条件的记录
	 * @param keyword
	 * @return 上传记录列表
	 */
	List<UpRecords> queryByKeyword(String keyword);
	
	/**
	 * 持久化指定上传记录
	 * @param up
	 * @return 持久化后标识
	 */
	Integer save(UpRecords up);
	
	/**
	 * 删除指定上传记录
	 * @param up
	 */
	void delete(UpRecords up);
}
