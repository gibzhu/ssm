package com.qhcs.ssm.service.admin;

import java.util.List;

import com.qhcs.ssm.entity.admin.SysFunction;

/**
 * 
 * 系统用户职能服务接口
 * 
 * @version 2017年5月26日下午2:22:15
 * @author zhuwenbin
 */
public interface SysFunctionService {

	/**
	 * 
	 * 根据用户id查找权限
	 * 
	 * @version 2017年5月26日下午2:23:55
	 * @author zhuwenbin
	 * @param userId
	 * @return
	 */
	public List<SysFunction> findPermissionsByUserId(int userId);
}
