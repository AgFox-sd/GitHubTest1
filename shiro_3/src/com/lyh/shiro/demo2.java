package com.lyh.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class demo2 {
	public static void main(String[] args) {
			Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro2.ini");
			SecurityManager securityManager=factory.getInstance();
			SecurityUtils.setSecurityManager(securityManager);
			Subject subject=SecurityUtils.getSubject();
			
			//进行身份认证
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1111");
			try {
				subject.login(token);
				System.out.println("认证成功！");
				if (subject.hasRole("role1")) {
					System.out.println("用户具有role1角色！");
				}
				if (subject.hasRole("role2")) {
					System.out.println("用户具有role2角色！");
				}
                if (subject.hasRole("role3")) {
					System.out.println("用户具有role3角色！");
				}
                if (subject.isPermitted("user:add")) {
					System.out.println("用户具有user：add权限");
				}
                if (subject.isPermitted("user:select")) {
					System.out.println("用户具有user：select权限");
				}
                if (subject.isPermitted("user:delete")) {
					System.out.println("用户具有user：delete权限");
				}
                if (subject.isPermitted("user:update")) {
					System.out.println("用户具有user：update权限");
				}
			} catch (AuthenticationException e) {
				System.out.println("认证失败！");
				// TODO: handle exception
			}
	}
}
