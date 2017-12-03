package com.qhcs.ssm.entity.admin;

import java.io.Serializable;

/**
 * 
 * 角色与职能关系实体
 * 
 * @version 2017年5月26日下午2:03:15
 * @author zhuwenbin
 */
public class SysRoleFunction implements Serializable {

	private Integer roleId;

	private Integer functionId;

	private static final long serialVersionUID = 1L;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", roleId=").append(roleId);
		sb.append(", functionId=").append(functionId);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		SysRoleFunction other = (SysRoleFunction) that;
		return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getFunctionId() == null ? other.getFunctionId() == null
						: this.getFunctionId().equals(other.getFunctionId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getFunctionId() == null) ? 0 : getFunctionId().hashCode());
		return result;
	}
}