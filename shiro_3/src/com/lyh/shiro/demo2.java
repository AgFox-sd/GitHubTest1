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
			
			//���������֤
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1111");
			try {
				subject.login(token);
				System.out.println("��֤�ɹ���");
				if (subject.hasRole("role1")) {
					System.out.println("�û�����role1��ɫ��");
				}
				if (subject.hasRole("role2")) {
					System.out.println("�û�����role2��ɫ��");
				}
                if (subject.hasRole("role3")) {
					System.out.println("�û�����role3��ɫ��");
				}
                if (subject.isPermitted("user:add")) {
					System.out.println("�û�����user��addȨ��");
				}
                if (subject.isPermitted("user:select")) {
					System.out.println("�û�����user��selectȨ��");
				}
                if (subject.isPermitted("user:delete")) {
					System.out.println("�û�����user��deleteȨ��");
				}
                if (subject.isPermitted("user:update")) {
					System.out.println("�û�����user��updateȨ��");
				}
			} catch (AuthenticationException e) {
				System.out.println("��֤ʧ�ܣ�");
				// TODO: handle exception
			}
	}
}
