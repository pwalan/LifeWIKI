package dao;

import java.util.List;

import domain.Friends;

/**
 * 对好友表操作的接口
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:55:09
 */
public interface FriendsDao {
	/**
	 * 根据用户id得到用户好友id
	 * @param uid
	 * @return
	 */
	List<Friends> queryByUid(int uid);
	
	/**
	 * 持久化指定的好友记录实例
	 * @param friends
	 * @return 持久化后标识
	 */
	Integer save(Friends friends);
	
	/**
	 * 删除指定的好友记录实例
	 * @param friends
	 */
	void delete(Friends friends);
}
