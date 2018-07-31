package com.cn.web.commons;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装分页数据的对象
 * @author Ivan
 *
 */
public class Page implements Serializable {

	private int currentPageNum;//当前页			*
	private int pageSize = 5;//每页显示的条数		*
	private int totalRecords;//总记录条数			*
	private int startIndex;//查询的开始记录索引		*
	private int totalPageNum;//总页数				*
	private int prePageNum;//上一页				*
	private int nextPageNum;//下一页				*
	private List records;//分好页的结果集（最多只能有5个对象）

	//用于显示页码的属性。页面上最多显示9个页码
	private int beginPageNum;
	private int endPageNum;

	/**
	 * 要想使用此类，必须使用2个参数
	 * @param currentPageNum 当前页
	 * @param totalRecords   总记录条数
	 */
	public Page(int currentPageNum, int totalRecords) {
		this.currentPageNum = currentPageNum;
		this.totalRecords = totalRecords;

		//计算开始记录的索引
		startIndex = (currentPageNum - 1) * pageSize;

		//计算总页数
		totalPageNum = totalRecords % pageSize == 0 ? totalRecords / pageSize : totalRecords / pageSize + 1;

		//计算页号
		if (totalPageNum < 9) {
			beginPageNum = 1;
			endPageNum = totalPageNum;
		} else {
			beginPageNum = currentPageNum - 4;
			endPageNum = currentPageNum + 4;
			if (beginPageNum < 1) {
				beginPageNum = 1;
				endPageNum = beginPageNum + 8;
			}
			if (endPageNum > totalPageNum) {
				endPageNum = totalPageNum;
				beginPageNum = endPageNum - 8;
			}
		}

	}

	public int getPrePageNum() {
		//计算上一页
		prePageNum = currentPageNum - 1;
		if (prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public int getNextPageNum() {
		//计算下一页
		nextPageNum = currentPageNum + 1;
		if (nextPageNum > totalPageNum) {
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

}
