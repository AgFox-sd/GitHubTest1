package com.teams.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	
	
	@RequestMapping("/add")
	public String add() {
		System.out.println("add...");
		return "/user/add";
	}
	
	@RequestMapping("/update")
	public String update() {
		System.out.println("update...");
		return "/user/update";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		System.out.println("login...");
		return "/login";
	}
	
	@RequestMapping("/noAuth")
	public String noAuth() {
		System.out.println("noAuth...");
		return "/noAuth";
	}
	
	/*
	 * 测试thymeleaf
	 */
	@RequestMapping("/testThymeleaf")
	public  String testThymeleaf(Model model) {
		//存数据
		model.addAttribute("name", "zp");
		//返回index.html
		return  "index";
	}
	
	
	
	/*
	 * 登录逻辑处理
	 * */
	
	@RequestMapping("/Login")
	public String login(String username,String password,Model model) {
		
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		//使用shiro编写认证操作
		//1:获取Subject
		Subject subject=SecurityUtils.getSubject();
		//2：封装用户数据
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		
		//3：执行登录方法
		try {
			subject.login(token);
			
			//登录成功
			//跳转到index.html
			return "redirect:/testThymeleaf";
		} catch (UnknownAccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//登录失败:用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "Login";
		}catch (IncorrectCredentialsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//登录失败:密码错误
			model.addAttribute("msg", "密码错误");
			return "Login";
		}
		
	}
}
