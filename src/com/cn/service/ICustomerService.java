package com.cn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cn.domain.BaseDict;
import com.cn.domain.Customer;
import com.cn.web.commons.Page;

/**
 * 客户的业务层接口
 * @author Ivan
 *
 */
public interface ICustomerService {

	/**
	 * 查询客户列表
	 * @param dCriteria	查询的条件
	 * @param num		当前页
	 * @return page 	封装好的分页信息
	 */
	Page findAllCustomer(DetachedCriteria dCriteria,Integer num);
	
	/**
	 * 使用投影查询，查询客户列表
	 * @return
	 */
	List<Customer> findAllCustomer();
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);

	/**
	 * 查询所有客户来源
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();

	/**
	 * 查询所有客户级别
	 * @return
	 */
	List<BaseDict> findAllCustomerLevel();

	/**
	 * 根据ID删除客户
	 * @param custId
	 */
	void removeCustomer(Long custId);

	/**
	 * 根据ID查询客户
	 * @param custId
	 */
	Customer findCustomerById(Long custId);

	/**
	 * 更新客户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);

}
