package com.qhcs.ssm.common.auth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qhcs.ssm.common.dto.ShiroUser;
import com.qhcs.ssm.entity.admin.SysFunction;
import com.qhcs.ssm.entity.admin.SysRole;
import com.qhcs.ssm.entity.admin.SysUser;
import com.qhcs.ssm.service.admin.SysFunctionService;
import com.qhcs.ssm.service.admin.SysRoleService;
import com.qhcs.ssm.service.admin.SysUserService;

/**
 * 
 * shiro认证
 * 
 * @version 2017年5月26日下午2:00:20
 * @author zhuwenbin
 */
public class ShiroDbRealm extends AuthorizingRealm {

	private static final String ALGORITHM = "MD5";

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysFunctionService sysFunctionService;

	/**
	 * 权限相关
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 加载用户的roles
		List<SysRole> roles = sysRoleService.findRolesByUserId(shiroUser.getUserId());
		for (SysRole role : roles) {
			authorizationInfo.addRole(role.getRoleName());
		}
		// 加载用户的permissions
		List<SysFunction> permissions = sysFunctionService.findPermissionsByUserId(shiroUser.getUserId());
		Set<String> stringPermissions = new HashSet<String>(permissions.size());
		for (SysFunction sysFunction : permissions) {
			if (StringUtils.isNotBlank(sysFunction.getPermission())) {
				stringPermissions.add(sysFunction.getPermission());
			}
		}
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;
	}

	/**
	 * 登陆时回调
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser sysUser = sysUserService.findSysUserByName(token.getUsername());
		if (sysUser == null) {
			// 没找到帐号
			throw new UnknownAccountException();
		}
		if (sysUser.getStatus() == 1) {
			// 帐号锁定
			throw new LockedAccountException();
		}
		if (sysUser.getStatus() == 2) {
			// 没找到帐号
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(
				new ShiroUser(sysUser.getUserId(), sysUser.getUserName(), sysUser.getRealName()), sysUser.getPassword(), // 密码
				getName() // realm name
		);
	}

	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	/*
	 * @PostConstruct public void initCredentialsMatcher() {
	 * HashedCredentialsMatcher matcher = new
	 * HashedCredentialsMatcher(ALGORITHM); setCredentialsMatcher(matcher); }
	 */

	/**
	 * 清空用户关联权限认证，待下次使用时重新加载
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}
}
