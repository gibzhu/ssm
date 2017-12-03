package com.qhcs.ssm.dao.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhcs.ssm.common.dao.BaseDao;
import com.qhcs.ssm.entity.admin.SysFunction;

/**
 * 
 * 系统用户职能数据库访问接口
 * 
 * @version 2017年5月26日下午2:12:28
 * @author zhuwenbin
 */
@Repository
public interface SysFunctionDao extends BaseDao<SysFunction> {

	/**
	 * 
	 * 根据用户id查找权限
	 * 
	 * @version 2017年5月26日下午2:26:20
	 * @author zhuwenbin
	 * @param userId
	 * @return
	 */
	public List<SysFunction> findFunctionsByUserId(int userId);
}