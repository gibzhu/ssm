package com.qhcs.ssm.entity.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 职能实体
 * 
 * @version 2017年5月26日下午2:02:27
 * @author zhuwenbin
 */
public class SysFunction implements Serializable {

	private Integer functionId;

	private Integer parentId;

	private String functionName;

	private String functionUrl;

	private Boolean functionType;

	private String permission;

	private Date createTime;

	private Integer sort;

	private static final long serialVersionUID = 1L;

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName == null ? null : functionName.trim();
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl == null ? null : functionUrl.trim();
	}

	public Boolean getFunctionType() {
		return functionType;
	}

	public void setFunctionType(Boolean functionType) {
		this.functionType = functionType;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "SysFunction{" + "functionId=" + functionId + ", parentId=" + parentId + ", functionName='"
				+ functionName + '\'' + ", functionUrl='" + functionUrl + '\'' + ", functionType=" + functionType
				+ ", permission='" + permission + '\'' + ", createTime=" + createTime + ", sort=" + sort + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SysFunction that = (SysFunction) o;

		if (functionId != null ? !functionId.equals(that.functionId) : that.functionId != null)
			return false;
		if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null)
			return false;
		if (functionName != null ? !functionName.equals(that.functionName) : that.functionName != null)
			return false;
		if (functionUrl != null ? !functionUrl.equals(that.functionUrl) : that.functionUrl != null)
			return false;
		if (functionType != null ? !functionType.equals(that.functionType) : that.functionType != null)
			return false;
		if (permission != null ? !permission.equals(that.permission) : that.permission != null)
			return false;
		if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null)
			return false;
		return sort != null ? sort.equals(that.sort) : that.sort == null;

	}

	@Override
	public int hashCode() {
		int result = functionId != null ? functionId.hashCode() : 0;
		result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
		result = 31 * result + (functionName != null ? functionName.hashCode() : 0);
		result = 31 * result + (functionUrl != null ? functionUrl.hashCode() : 0);
		result = 31 * result + (functionType != null ? functionType.hashCode() : 0);
		result = 31 * result + (permission != null ? permission.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		result = 31 * result + (sort != null ? sort.hashCode() : 0);
		return result;
	}
}