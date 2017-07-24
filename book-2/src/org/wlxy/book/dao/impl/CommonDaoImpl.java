package org.wlxy.book.dao.impl;

import java.sql.ResultSet;
import java.util.Collection;

import org.wlxy.book.commons.DataUtil;
import org.wlxy.book.jdbc.JDBCExecutor;
import org.wlxy.book.vo.ValueObject;

/**
 *  数据访问层基础类
 * @author huangtao
 * @date 2017-07-06  
 *
 */
public class CommonDaoImpl {
	
    //获得jdbc执行类实例
	public JDBCExecutor  getJDBCExecutor (){
		
		return JDBCExecutor.getJDBCExecutor();
	}
	
	
	//根据SQL语句，存放结果的返回集合、具体的对象映射获得操作的结果
	public Collection getDatas (String sql ,Collection<ValueObject> result ,Class c ){
		//执行SQL返回ResultSet对象
				ResultSet rs = getJDBCExecutor().executeQuery(sql);
				//对ResultSet进行封装并返回集合
				return DataUtil.getDatas(result, rs, c);
	}	
}
