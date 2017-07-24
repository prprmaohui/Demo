package org.wlxy.book.service;

import java.util.Collection;

import org.wlxy.book.vo.Publisher;

/**
 * 出版社业务接口
 * @author huangtao
 *
 */
public interface PublisherService {

	
	//出版社信息添加
	
	Publisher add (Publisher  publisher);
	
	//出版社信息修改
	Publisher update(Publisher  publisher);
	
	//查询全量出版社
	Collection<Publisher> queryAll();
	
	//根据ID查询出版社
	Publisher queryByID(String id );
  
	//根据名称模糊查询出版社
	Collection<Publisher> queryByName(String name);

   
}
