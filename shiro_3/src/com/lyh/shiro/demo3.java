package com.lyh.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class demo3 {
	public static void main(String[] args) {
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		
		//进行身份认证
		UsernamePasswordToken token=new UsernamePasswordToken("tc", "999");
		try {
			subject.login(token);
			System.out.println("认证成功");
			//认证通过后，判断用户具有哪些角色和权限
			//权限授权
			if(subject.isPermitted("user:select")) {
				System.out.println("用户具有查询用户的权限");
			}
			if(subject.isPermitted("user:delete")) {
				System.out.println("用户具有删除用户的权限");
			}
			if(subject.isPermitted("user:update")) {
				System.out.println("用户具有修改用户的权限");
			}
			if(subject.isPermitted("user:add")) {
				System.out.println("用户具有添加用户的权限");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("认证失败");
		}
	}
}