package com.cn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cn.dao.ILinkManDao;
import com.cn.domain.LinkMan;

/**
 * 联系人的持久层实现类
 * @author Ivan
 *
 */
@Repository("linkmanDao")
public class LinkManDaoImpl implements ILinkManDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate HibernateTemplate;
	
	@Override
	public void save(LinkMan linkman) {
		HibernateTemplate.save(linkman);
	}

	@Override
	public List<LinkMan> findAll(DetachedCriteria dCriteria) {
		return (List<LinkMan>) HibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public void delete(Long lkmId) {
		HibernateTemplate.delete(findById(lkmId));
	}

	@Override
	public LinkMan findById(Long lkmId) {
		return HibernateTemplate.get(LinkMan.class, lkmId);
	}

	@Override
	public void update(LinkMan linkman) {
		HibernateTemplate.update(linkman);
	}

}
