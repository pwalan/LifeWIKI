package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;
import domain.User;

/**
 * 对用户信息操作的实现
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午10:18:44
 */

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	@Override
	public List<User> queryByUserName(String username) {
		return (List<User>)getHibernateTemplate()
				.find("from User u where u.username=?", username);
	}
	
	@Override
	public List<User> queryByID(int id) {
		return (List<User>)getHibernateTemplate()
				.find("from User u where u.id=?", id);
	}
	
	@Override
	public Integer save(User user) {
		return (Integer)getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}
}
