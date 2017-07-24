package org.wlxy.book.service.impl;

import java.util.Collection;

import org.wlxy.book.dao.PublisherDao;
import org.wlxy.book.service.PublisherService;
import org.wlxy.book.vo.Publisher;

public class PublisherServiceImpl implements PublisherService {

	PublisherDao publisherDao ;
	
	//���췽��
	 public PublisherServiceImpl(PublisherDao publisherDao ){
		 this.publisherDao =publisherDao;
		 
	 }
	@Override
	//��ӳ�����
	public Publisher add(Publisher publisher) {
		String resut=   publisherDao.add(publisher);
		return  this.queryByID(resut);
	}

	@Override
	//�޸ĳ�����
	public Publisher update(Publisher publisher) {
		String result= publisherDao.update(publisher);	
		return  this.queryByID(result);
	}

	@Override
	//��ѯȫ���ĳ�����
	public Collection<Publisher> queryAll() {
		return  publisherDao.findAll();
	}

	@Override
	//����ID��ѯ������
	public Publisher queryByID(String id) {
		 return publisherDao.findByID(id);
	}

	@Override
	//�������Ʋ�ѯ������
	public Collection<Publisher> queryByName(String name) {
		return  publisherDao.findByName(name) ;
	}

}
