package dao;

import java.util.List;

import entity.book;

public interface IUserDao {

	int login(String uname, String pwd);

	List<book> selectAll();

	book selectAll(int id);

}
