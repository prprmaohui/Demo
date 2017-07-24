package org.wlxy.book.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.wlxy.book.dao.PublisherDao;
import org.wlxy.book.jdbc.JDBCExecutor;
import org.wlxy.book.vo.Publisher;

/**
 * 出版社DAO实现类
 * 
 * @author huangtao
 * @version  1.0
 *  */
public class PublisherDaoImpl extends CommonDaoImpl implements PublisherDao{
	
	@Override
	//添加出版社
	public String add(Publisher publisher) {
		//根据传入的出版社对象，往数据库中添加出版社信息
		String  sql= "insert into  t_publisher  values ("+publisher.getPUB_NAME()+","+
				publisher.getPUB_TEL()+","+publisher.getPUB_LINK_MAN()+","+publisher.getPUB_INTRO();
		//将执行结果返回
		String result =  String.valueOf(JDBCExecutor.getJDBCExecutor().executeUpdate(sql));
		return result;
	}
	
	@Override
	//查询所有的出版社信息
	public Collection<Publisher> findAll() {
		String sql = "select * from T_PUBLISHER  order by id desc ";
		//将执行结果返回
		return getDatas(sql, new Vector(), Publisher.class);
	}

	@Override
	//根据ID查询出版社
	public Publisher findByID(String id) {
		String sql = "select * from T_PUBLISHER where id = "+id;
		List<Publisher> datas = (List<Publisher>)getDatas(sql, new ArrayList() ,Publisher.class);
		return   datas.size() ==1?datas.get(0):null;
	}

	@Override
	//根据名称查询出版社
	public Collection<Publisher> findByName(String name) {
		String sql = "select * from T_PUBISHER where pub_name like %"+name+"%";
		//将执行结果返回
		return getDatas(sql, new Vector(), Publisher.class);
	}

	@Override
	//修改出版社信息
	public String update(Publisher publisher) {
		String sql = "UPDATE T_PUBISHER SET pub_name ="+publisher.getPUB_NAME()
		+" and pub_link_man = "+publisher.getPUB_LINK_MAN()+" and pub_tel = "
		+publisher.getPUB_TEL() + " and pub_intro = "+publisher.getPUB_INTRO()+ " where id = "+publisher.getID();
		
		 String.valueOf(JDBCExecutor.getJDBCExecutor().executeUpdate(sql));
		return  String.valueOf(publisher.getID());
	}
}
