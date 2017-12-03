package com.qhcs.ssm.entity.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 角色实体
 * 
 * @version 2017年5月26日下午2:03:00
 * @author zhuwenbin
 */
public class SysRole implements Serializable {

	private Integer roleId;

	private String roleName;

	private String description;

	private Date createTime;

	private static final long serialVersionUID = 1L;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysRole{" + "roleId=" + roleId + ", roleName='" + roleName + '\'' + ", description='" + description
				+ '\'' + ", createTime=" + createTime + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SysRole sysRole = (SysRole) o;

		if (roleId != null ? !roleId.equals(sysRole.roleId) : sysRole.roleId != null)
			return false;
		if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null)
			return false;
		if (description != null ? !description.equals(sysRole.description) : sysRole.description != null)
			return false;
		return createTime != null ? createTime.equals(sysRole.createTime) : sysRole.createTime == null;

	}

	@Override
	public int hashCode() {
		int result = roleId != null ? roleId.hashCode() : 0;
		result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		return result;
	}
}