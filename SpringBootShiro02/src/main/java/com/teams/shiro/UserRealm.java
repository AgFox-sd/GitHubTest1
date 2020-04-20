package com.teams.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.teams.pojo.User;
import com.teams.service.UserService;

/*
 * 自定义Realm
 * */
public class UserRealm extends AuthorizingRealm{

	/*
	 * 执行授权逻辑
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		
		//给资源进行授权
		SimpleAuthorizationInfo  info=new SimpleAuthorizationInfo();
		
		//添加资源授权字符串   filterMap.put("/add", "perms[user:add]");
		//到数据库查询当前登录用户授权字符串
		//获取当前登录用户
		Subject subject=SecurityUtils.getSubject();
		User user=(User) subject.getPrincipal();
		User dbuser=userService.findById(user.getId());
		
		info.addStringPermission(dbuser.getPerms());
		return info;
		
	}
	
	//注入业务
	@Autowired
	private UserService userService;
	
	
	
	/*
	 * 执行认证逻辑
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		//编写shiro判断逻辑，判断用户名和密码
			//1：判断用户名
			UsernamePasswordToken token1=(UsernamePasswordToken)token;
			User user=userService.findByname(token1.getUsername());
			
			if(user==null) {
				//用户名不存在
				return null;//shiro底层会抛出UnknownAccountException
			}
			//2：判断密码
			return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}

}
