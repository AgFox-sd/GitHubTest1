package service;

import java.util.List;

import entity.book;

public interface IUserService {

	int login(String uname, String pwd);

	List<book> selectAll();

	book selectAll(int id);
}
