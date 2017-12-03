package com.qhcs.ssm.entity.article;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 文章实体
 * 
 * @version 2017年5月16日下午3:16:22
 * @author zhuwenbin
 */
public class Article implements Serializable {

	private static final long serialVersionUID = 6911787171385544147L;

	/**
	 * 文章id
	 */
	private int id;

	/**
	 * 栏目id
	 */
	private int columnId;

	/**
	 * 文章标题
	 */
	private String title;

	/**
	 * 文章内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 修改时间
	 */
	private Date updateDate;

	public Article() {
		super();
	}

	public Article(int columnId, String title, String content, Date createDate, Date updateDate) {
		super();
		this.columnId = columnId;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Article(int id, int columnId, String title, String content, Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.columnId = columnId;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", columnId=" + columnId + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
