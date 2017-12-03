package com.qhcs.ssm.controller.admin;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.common.controller.BaseController;
import com.qhcs.ssm.entity.admin.SysUser;

/**
 * 
 * 系统管理员控制类
 * 
 * @version 2017年5月26日下午2:30:30
 * @author zhuwenbin
 */
@Controller
public class AdminController extends BaseController {

	/**
	 * 首页
	 *
	 * @return
	 */
	@RequestMapping(value = { "/admin", "/admin/index" })
	@RequiresPermissions("user:login")
	public String index() {
		return "admin/index";
	}

	/**
	 * 跳转到登录页面
	 *
	 * @return
	 */
	@GetMapping("/admin/login")
	public String login() {
		return "admin/login";
	}

	/**
	 * 管理员登录
	 *
	 * @param sysUser
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/login")
	public String login(@Valid SysUser sysUser, BindingResult result, Model model) {
		String error = null;
		if (result.hasErrors()) {
			error = result.getFieldError().getDefaultMessage();
			model.addAttribute("errorMsg", error);
			return "admin/login";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(), sysUser.getPassword());
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名不存在";
		} catch (LockedAccountException e) {
			error = "用户名已冻结";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch处理
			error = "其他错误：" + e.getMessage();
		}
		if (error != null) {
			model.addAttribute("errorMsg", error);
			return "admin/login";
		}
		return "redirect:/admin/index";
	}

	/**
	 * 管理员退出
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/logout")
	public String logout(Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/admin/login";
	}
}
