package com.lyh.realm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.lyh.pojo.user;

public class UserRealm extends AuthorizingRealm{

	@Override
	public String getName() {
		return "UserRealm";
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=principals.getPrimaryPrincipal().toString();
		System.out.println(username+"==================");
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
	    SqlSession session=factory.openSession(true);
	    List<String> permissions = session.selectList("com.lyh.mapper.UserMapper.selectXq",username);
	    SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
	    SqlSession session=factory.openSession(true);
	    user user = session.selectOne("com.lyh.mapper.UserMapper.selectPassword", username);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username, user.getPassword(),
				ByteSource.Util.bytes(user.getPassword_salt()),getName());
		return info;	
	}

}
