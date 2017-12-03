package com.qhcs.ssm.service.impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.admin.SysUserDao;
import com.qhcs.ssm.entity.admin.SysUser;
import com.qhcs.ssm.service.admin.SysUserService;

/**
 * 
 * 系统用户服务接口实现类
 * 
 * @version 2017年5月26日下午2:24:53
 * @author zhuwenbin
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUser findSysUserByName(String userName) {
		return sysUserDao.findSysUserByName(userName);
	}
}
