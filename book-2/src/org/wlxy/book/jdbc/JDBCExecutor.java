package org.wlxy.book.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecutor {
	
	//获取JDBC相关属性
	private static String JDBC_DRIVER = PropertiesUtil.JDBC_DRIVER;//获得驱动
	private static String JDBC_URL = PropertiesUtil.JDBC_URL;//获得URL
	private static String JDBC_USERNAME = PropertiesUtil.JDBC_USERNAME;//获得用户名
	private static String JDBC_PASSWORD = PropertiesUtil.JDBC_PASSWORD;//获得密码
	
	//新建数据库连接对象
	private Connection connection ;
	//维护一个本类对象
	private static JDBCExecutor jDBCExecutor = new JDBCExecutor();
	//新建数据库连接申明
	private static Statement  stmt ;
	
	
	//私有构造器
	private JDBCExecutor(){
		//初始化JDBC ，并让驱动加载到JVM
		try {
			Class.forName(JDBC_DRIVER);
			//创建数据库连接
			connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
			//创建statement对象
			stmt = connection.createStatement();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//提供一个静态方法返回本类的实例	
	public static  JDBCExecutor getJDBCExecutor(){
		if(jDBCExecutor == null){
			//如果本类所维护jdbcExecutor属性为空,则调用私有的构造器获得实例
			jDBCExecutor= new JDBCExecutor();
		}	
		return  jDBCExecutor;
	}
	
	//执行查询的SQL，获取数据记录
	public ResultSet  executeQuery (String sql) {
		ResultSet result = null  ;
		//执行查询语句;
		try {
			result  =  stmt.executeQuery(sql);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result ;
	}
	
	
	//执行修改操作的方法，修改数据记录
	public int executeUpdate(String sql){
		int result = -1 ;
		 try {
			 result =stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//执行数据删除的方法，删除数据记录
		public int executeDelete(String sql){
			int result = -1 ;
			try {
				result =stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return result ;
		}
	
	
	public static void main(String[] args) {
	  
		JDBCExecutor jDBCExecutor = new JDBCExecutor();
		
      //方法测试一---数据的查询
		int id =-1;		//通过指定的SQL查询出结果集
		ResultSet result =jDBCExecutor.executeQuery("select id  from t_user");
		//通过迭代，循环读取结果集中的数据				
		try {
			while(result.next()){
			id =result.getInt(1);
			System.out.println("User表中的ID值有"+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
	  
//方法测试二---数据的修改
	//通过指定的SQL查询出结果集
//	int result =jDBCExecutor.executeUpdate("update  t_user set  user_name='root' where 1=1 ");
//	 System.out.println(result);
	  

//方法测试三---数据的删除
	//通过指定的SQL查询出结果集
//		int result =jDBCExecutor.executeDelete("delete from  t_user where id <10 ");
//		 System.out.println(result); 
//	}
	}
}
