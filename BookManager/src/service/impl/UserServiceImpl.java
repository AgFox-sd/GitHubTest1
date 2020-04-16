package service.impl;

import java.util.List;

import dao.IUserDao;
import entity.book;
import service.IUserService;

public class UserServiceImpl implements IUserService {
IUserDao dao = new dao.impl.UserDaoImpl();
	@Override
	public int login(String uname, String pwd) {
		return dao.login(uname,pwd);
	}
	@Override
	public List<book> selectAll() {
		return dao.selectAll();
	}
	@Override
	public book selectAll(int id) {
		// TODO Auto-generated method stub
		return dao.selectAll(id);
	}

}
