package com.qhcs.ssm.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.admin.SysRoleDao;
import com.qhcs.ssm.entity.admin.SysRole;
import com.qhcs.ssm.service.admin.SysRoleService;

/**
 * 
 * 系统用户角色服务接口实现类
 * 
 * @version 2017年5月26日下午2:25:21
 * @author zhuwenbin
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public List<SysRole> findRolesByUserId(int userId) {
		return sysRoleDao.findRolesByUserId(userId);
	}
}
