package com.cn.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cn.domain.LinkMan;

/**
 * 联系人的业务层接口
 * @author Ivan
 *
 */
public interface ILinkManService {

	/**
	 * 新增联系人
	 * @param linkman
	 */
	void saveLinkMan(LinkMan linkman);

	/**
	 * 查询所有联系人
	 * @param dCriteria
	 * @return
	 */
	List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria);

	/**
	 * 删除联系人
	 * @param lkmId
	 */
	void removeLinkMan(Long lkmId);

	/**
	 * 根据ID查询联系人信息
	 * @param lkmId
	 * @return
	 */
	LinkMan findLInkManById(Long lkmId);

	/**
	 * 更新联系人
	 * @param linkman
	 */
	void updateLinkMan(LinkMan linkman);

}
