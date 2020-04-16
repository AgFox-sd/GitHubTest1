package com.lyh.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class demo1 {
	public static void main(String[] args) {
		Md5Hash md5 = new Md5Hash("123456","sn",2);
		System.out.println(md5.toString());
		/*md5 = new Md5Hash("8888","ls",2);
		System.out.println(md5.toString());
		md5 = new Md5Hash("999","ww",2);
		System.out.println(md5.toString());
		md5 = new Md5Hash("999","ww",2);
		System.out.println(md5.toString());*/
		
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject=SecurityUtils.getSubject();
		
		//进行身份认证
		UsernamePasswordToken token=new UsernamePasswordToken("tc", "999");
		try {
			subject.login(token);
			System.out.println("认证成功");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("认证失败");
		}
	}
}
