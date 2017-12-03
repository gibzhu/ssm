package com.qhcs.ssm.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.admin.SysFunctionDao;
import com.qhcs.ssm.entity.admin.SysFunction;
import com.qhcs.ssm.service.admin.SysFunctionService;

/**
 * 
 * 系统用户权限服务接口实现类
 * 
 * @version 2017年5月26日下午2:25:45
 * @author zhuwenbin
 */
@Service
public class SysFunctionServiceImpl implements SysFunctionService {

	@Autowired
	private SysFunctionDao sysFunctionDao;

	@Override
	public List<SysFunction> findPermissionsByUserId(int userId) {
		return sysFunctionDao.findFunctionsByUserId(userId);
	}
}
