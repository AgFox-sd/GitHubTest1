package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IUserDao;
import entity.book;
import util.DBUtils;

public class UserDaoImpl implements IUserDao {
DBUtils dbutil = new DBUtils();
	@Override
	public int login(String uname, String pwd) {
        String sql = "select count(1) from us where username=? and userpwd=?";
        Object[] params = {uname,pwd};
        ResultSet rs = dbutil.executeQuery(sql, params);
        int num = 0;
        try {
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					num=1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	@Override
	public List<book> selectAll() {
        List<book> list = new ArrayList<book>();
        String sql = "select * from books";
        ResultSet rs = dbutil.executeQuery(sql, null);
        try {
			while(rs.next()) {
				book bk = new book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8),rs.getDouble(9));
			    list.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public book selectAll(int id) {
		   String sql = "select * from books where bookId="+id+"";
		   book bk = null;
	        ResultSet rs = dbutil.executeQuery(sql, null);
	        try {
				if(rs.next()) {
					 bk = new book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getLong(7),rs.getLong(8),rs.getDouble(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bk;
		}
	}
