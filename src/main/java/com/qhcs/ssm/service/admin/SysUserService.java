package com.qhcs.ssm.service.admin;

import com.qhcs.ssm.entity.admin.SysUser;

/**
 * 
 * 系统用户服务接口
 * 
 * @version 2017年5月26日下午2:24:14
 * @author zhuwenbin
 */
public interface SysUserService {

	/**
	 * 
	 * 根据用户名查找用户
	 * 
	 * @version 2017年5月26日下午2:24:35
	 * @author zhuwenbin
	 * @param userName
	 * @return
	 */
	public SysUser findSysUserByName(String userName);
}
