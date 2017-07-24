package org.wlxy.book.dao.impl;

import java.sql.ResultSet;
import java.util.Collection;

import org.wlxy.book.commons.DataUtil;
import org.wlxy.book.jdbc.JDBCExecutor;
import org.wlxy.book.vo.ValueObject;

/**
 *  ���ݷ��ʲ������
 * @author huangtao
 * @date 2017-07-06  
 *
 */
public class CommonDaoImpl {
	
    //���jdbcִ����ʵ��
	public JDBCExecutor  getJDBCExecutor (){
		
		return JDBCExecutor.getJDBCExecutor();
	}
	
	
	//����SQL��䣬��Ž���ķ��ؼ��ϡ�����Ķ���ӳ���ò����Ľ��
	public Collection getDatas (String sql ,Collection<ValueObject> result ,Class c ){
		//ִ��SQL����ResultSet����
				ResultSet rs = getJDBCExecutor().executeQuery(sql);
				//��ResultSet���з�װ�����ؼ���
				return DataUtil.getDatas(result, rs, c);
	}	
}
