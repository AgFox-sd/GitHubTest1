package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class DBUtils {
	
	private static String url="";
	private static String userName="";
	private static String userPwd="";//.class
	private static String driverClass="";
	
	static{
		try {
			//创建一个属性集对象
			Properties pro=new Properties();
			//通过pro对象去加载jdbc.properties文件
			InputStream in=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			pro.load(in);
			driverClass=pro.getProperty("driverClass");
			userName=pro.getProperty("userName");
			userPwd=pro.getProperty("userPwd");
			url=pro.getProperty("url");
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  

	//提供获取连接对象的方法  
	public static Connection getConnection(){
	    Connection cn=null;
		try {
			cn = DriverManager.getConnection(url, userName,userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return cn;
	}
	 
	//提供关闭资源的方法
	public void closeAll(Connection cn,Statement st,ResultSet rs){
		try {
			    if(rs!=null) rs.close();
			    if(st!=null) st.close();
				if(cn!=null) cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	//执行增删改的方法，返回受影响的行数
	public int executeUpdate(String sql,Object[] parms){
		Connection cn=getConnection();
		PreparedStatement pst=null;
		int count=0;
		try {
			pst=cn.prepareStatement(sql);
			//设置参数
			if(parms!=null){
				for(int i=0;i<parms.length;i++){
					pst.setObject(i+1, parms[i]);
				}
			}
		    count=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			 closeAll(cn, pst, null);
		}
		return count;
	}
	
	//执行查询的方法，返回结果集
	public ResultSet executeQuery(String sql,Object[] parms){
		Connection cn=getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=cn.prepareStatement(sql);
			//设置参数
			if(parms!=null){
				for(int i=0;i<parms.length;i++){
					pst.setObject(i+1, parms[i]);
				}
			}
			rs=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
