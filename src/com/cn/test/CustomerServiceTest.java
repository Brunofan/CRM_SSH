package com.cn.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.domain.Customer;
import com.cn.service.ICustomerService;

/**
 * 测试客户的业务层
 * @author Ivan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/spring/applicationContext.xml"})
public class CustomerServiceTest {

	@Autowired
	private ICustomerService cs;
	
	@Test
	public void testFindAll() {
//		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
//		dCriteria.add(Restrictions.eq("custSource.dictId", "7"));
//		//dCriteria.add(Restrictions.eq("custLevel", "普通客户"));
//		List list = cs.findAllCustomer(dCriteria);
//		for(Object o:list) {
//			System.out.println(o);
//		}
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setCustName("crm customer");
		cs.saveCustomer(c);
	}
	
	@Test
	public void test2(){
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		//2.设置查询条件
		dCriteria.add(Restrictions.like("custName", "%集%"));//from Customer where custName  like "%集%"
		dCriteria.add(Restrictions.eq("custLevel", "普通客户"));
		//3.执行对象的方法获取结果集
//		List list = cs.findAllCustomer(dCriteria);
//		for(Object o:list) {
//			System.out.println(o);
//		}
	}	

}
