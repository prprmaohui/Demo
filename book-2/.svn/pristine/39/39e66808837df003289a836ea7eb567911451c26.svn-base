package org.wlxy.book.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	// 新建一个属性文件对象
	private static Properties properties = new Properties();
	// 属性文件的路径
	private static String CONFIG = "/cfg/jdbc.properties";
	// 读取资源文件，设置输入流
	private static InputStream is = PropertiesUtil.class.getResourceAsStream(CONFIG);
    //数据库驱动
	public static String JDBC_DRIVER ;
	//数据库URL
	 public static String JDBC_URL ;
	//数据用户名
	 public static String JDBC_USERNAME ;
	//数据库密码
	 public static String JDBC_PASSWORD;
	 
	 static{
     //加载输入流
	 try {
		properties.load(is);
		  //获取配置文件中的静态属性
		 JDBC_DRIVER =properties.getProperty("jdbc.driver");
		 JDBC_URL =properties.getProperty("jdbc.url");
		 JDBC_USERNAME =properties.getProperty("jdbc.username");
		 JDBC_PASSWORD =properties.getProperty("jdbc.password");

	} catch (IOException e) {
		e.printStackTrace();
	}
   
	 }
}
