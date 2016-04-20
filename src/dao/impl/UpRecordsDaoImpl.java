package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UpRecordsDao;
import domain.UpRecords;

/**
 * 对上传记录操作的实现
 * @author AlanP
 * @date： 日期：2016年3月18日 时间：上午10:37:34
 */
public class UpRecordsDaoImpl extends HibernateDaoSupport implements UpRecordsDao{

	@Override
	public List<UpRecords> queryByUid(int uid) {
		return (List<UpRecords>)getHibernateTemplate()
				.find("from UpRecords u where u.uid=?", uid);
	}

	@Override
	public Integer save(UpRecords up) {
		return (Integer)getHibernateTemplate().save(up);
	}

	@Override
	public void delete(UpRecords up) {
		getHibernateTemplate().delete(up);
	}

	@Override
	public List<UpRecords> queryByKeyword(String keyword) {
		return (List<UpRecords>)getHibernateTemplate()
				.find("from UpRecords u where u.keyword=?", keyword);
	}

}
