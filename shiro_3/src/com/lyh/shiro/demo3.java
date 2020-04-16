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
		
		//���������֤
		UsernamePasswordToken token=new UsernamePasswordToken("tc", "999");
		try {
			subject.login(token);
			System.out.println("��֤�ɹ�");
			//��֤ͨ�����ж��û�������Щ��ɫ��Ȩ��
			//Ȩ����Ȩ
			if(subject.isPermitted("user:select")) {
				System.out.println("�û����в�ѯ�û���Ȩ��");
			}
			if(subject.isPermitted("user:delete")) {
				System.out.println("�û�����ɾ���û���Ȩ��");
			}
			if(subject.isPermitted("user:update")) {
				System.out.println("�û������޸��û���Ȩ��");
			}
			if(subject.isPermitted("user:add")) {
				System.out.println("�û���������û���Ȩ��");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("��֤ʧ��");
		}
	}
}