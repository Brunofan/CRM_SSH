package com.cn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cn.dao.ICustomerDao;
import com.cn.domain.Customer;

/**
 * 客户的持久层实现类
 * @author Ivan
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void saveCustomer(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void delete(Long custId) {
		hibernateTemplate.delete(findById(custId));
	}

	@Override
	public Customer findById(Long custId) {
		return hibernateTemplate.load(Customer.class, custId);
	}

	@Override
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) hibernateTemplate.find("select new Customer(custId,custName) from Customer");
	}

	@Override
	public int findTotalRecords(DetachedCriteria dCriteria) {
		dCriteria.setProjection(Projections.count("custId")); //把select * 改成了 select count(*)
		List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(dCriteria);
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dCriteria, int firstResult, int maxResults) {
		//把之前设置的Projection清除掉
		dCriteria.setProjection(null);
		return (List<Customer>) hibernateTemplate.findByCriteria(dCriteria, firstResult, maxResults);
	}

}
