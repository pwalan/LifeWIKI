package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.FriendsDao;
import domain.Friends;

/**
 * 对好友表操作的实现
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午10:28:00
 */
public class FriendsDaoImpl extends HibernateDaoSupport implements FriendsDao{

	@Override
	public List<Friends> queryByUid(int uid) {
		return (List<Friends>)getHibernateTemplate()
				.find("from Friends f where f.uid=?", uid);
	}

	@Override
	public Integer save(Friends friends) {
		return (Integer)getHibernateTemplate().save(friends);
	}

	@Override
	public void delete(Friends friends) {
		getHibernateTemplate().delete(friends);
	}

}
