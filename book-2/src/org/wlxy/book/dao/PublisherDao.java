package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.Publisher;

/**
 * 出版社数据层接口类
 * @author huangato
 *  
 */
public interface PublisherDao {

	//查找全部的出版社
	Collection<Publisher> findAll();
	
	//根据ID查找出版社
     
	Publisher findByID(String id);
	
	//根据名称查询出版社
	Collection<Publisher> findByName(String name);
	
	//修改出版社
	String  update(Publisher publisher);
	
	//添加出版社
	String   add(Publisher publisher);
}
