package com.qhcs.ssm.page.article;

import java.util.Date;

import com.qhcs.ssm.common.page.Page;

/**
 * 
 * 文章分页实体
 * 
 * @version 2017年5月23日上午10:07:40
 * @author zhuwenbin
 */
public class ArticlePage extends Page {

	/**
	 * 开始日期
	 */
	private Date startDate;

	/**
	 * 结束日期
	 */
	private Date endDate;

	/**
	 * 标题
	 */
	private String title;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
