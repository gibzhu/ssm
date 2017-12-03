package com.qhcs.ssm.entity.admin;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * 系统用户实体
 * 
 * @version 2017年5月26日下午2:03:54
 * @author zhuwenbin
 */
public class SysUser implements Serializable {

	private Integer userId;

	@NotNull(message = "用户名不能为空")
	@Size(max = 20, message = "用户名长度不能超过20个字符")
	private String userName;

	@NotNull(message = "密码不能为空")
	@Size(min = 32, max = 32, message = "密码长度不能超过32个字符")
	private String password;

	private String realName;

	private Integer status;

	private Date lastLoginTime;

	private String lastLoginIp;

	private Date createTime;

	private String email;

	private String tel;

	private static final long serialVersionUID = 1L;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "SysUser{" + "userId=" + userId + ", userName='" + userName + '\'' + ", password='" + password + '\''
				+ ", realName='" + realName + '\'' + ", status=" + status + ", lastLoginTime=" + lastLoginTime
				+ ", lastLoginIp='" + lastLoginIp + '\'' + ", createTime=" + createTime + ", email='" + email + '\''
				+ ", tel='" + tel + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SysUser sysUser = (SysUser) o;

		if (userId != null ? !userId.equals(sysUser.userId) : sysUser.userId != null)
			return false;
		if (userName != null ? !userName.equals(sysUser.userName) : sysUser.userName != null)
			return false;
		if (password != null ? !password.equals(sysUser.password) : sysUser.password != null)
			return false;
		if (realName != null ? !realName.equals(sysUser.realName) : sysUser.realName != null)
			return false;
		if (status != null ? !status.equals(sysUser.status) : sysUser.status != null)
			return false;
		if (lastLoginTime != null ? !lastLoginTime.equals(sysUser.lastLoginTime) : sysUser.lastLoginTime != null)
			return false;
		if (lastLoginIp != null ? !lastLoginIp.equals(sysUser.lastLoginIp) : sysUser.lastLoginIp != null)
			return false;
		if (createTime != null ? !createTime.equals(sysUser.createTime) : sysUser.createTime != null)
			return false;
		if (email != null ? !email.equals(sysUser.email) : sysUser.email != null)
			return false;
		return tel != null ? tel.equals(sysUser.tel) : sysUser.tel == null;

	}

	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (userName != null ? userName.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (realName != null ? realName.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
		result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
		result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (tel != null ? tel.hashCode() : 0);
		return result;
	}
}