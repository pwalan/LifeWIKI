package dao;

import java.util.List;

import domain.User;

/**
 * 对用户信息操作的接口
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午9:44:13
 */
public interface UserDao{
	/**
	 * 根据用户名得到用户信息
	 * @param username
	 * @return 用户实例
	 */
	List<User> queryByUserName(String username);
	
	/**
	 * 根据id得到用户信息
	 * @paran id
	 * @return 用户实例
	 */
	List<User> queryByID(int id);
	
	/**
	 * 持久化指定用户实例
	 * @param user
	 * @return 持久化后标识
	 */
	Integer save(User user);
	
	/**
	 * 更新指定用户实例
	 * @param user
	 */
	void update(User user);
}
