package com.qhcs.ssm.dao.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhcs.ssm.common.dao.BaseDao;
import com.qhcs.ssm.entity.admin.SysRole;

/**
 * 
 * 系统用户角色数据库访问接口
 * 
 * @version 2017年5月26日下午2:12:54
 * @author zhuwenbin
 */
@Repository
public interface SysRoleDao extends BaseDao<SysRole> {

	/**
	 * 
	 * 根据用户id查找角色
	 * 
	 * @version 2017年5月26日下午2:26:29
	 * @author zhuwenbin
	 * @param userId
	 * @return
	 */
	public List<SysRole> findRolesByUserId(int userId);
}