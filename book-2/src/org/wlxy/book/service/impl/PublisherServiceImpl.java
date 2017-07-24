package org.wlxy.book.service.impl;

import java.util.Collection;

import org.wlxy.book.dao.PublisherDao;
import org.wlxy.book.service.PublisherService;
import org.wlxy.book.vo.Publisher;

public class PublisherServiceImpl implements PublisherService {

	PublisherDao publisherDao ;
	
	//构造方法
	 public PublisherServiceImpl(PublisherDao publisherDao ){
		 this.publisherDao =publisherDao;
		 
	 }
	@Override
	//添加出版社
	public Publisher add(Publisher publisher) {
		String resut=   publisherDao.add(publisher);
		return  this.queryByID(resut);
	}

	@Override
	//修改出版社
	public Publisher update(Publisher publisher) {
		String result= publisherDao.update(publisher);	
		return  this.queryByID(result);
	}

	@Override
	//查询全部的出版社
	public Collection<Publisher> queryAll() {
		return  publisherDao.findAll();
	}

	@Override
	//根据ID查询出版社
	public Publisher queryByID(String id) {
		 return publisherDao.findByID(id);
	}

	@Override
	//根据名称查询出版社
	public Collection<Publisher> queryByName(String name) {
		return  publisherDao.findByName(name) ;
	}

}
