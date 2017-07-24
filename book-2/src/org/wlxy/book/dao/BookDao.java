package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.Book;

/**
 * @ClassName BookDao
 * @Description TODO(�鱾���ݲ�dao)
 * @author huangtao
 * @Date 2017��7��10�� ����10:04:08
 * @version 1.0.0
 */
public interface BookDao {
  //����ȫ�����鱾
    Collection<Book> findAll();
    
    //����ID�����鱾
     
    Book findByID(String id);
    
    //�������Ʋ�ѯ�鱾
    Collection<Book> findByName(String name);
    
    //�޸��鱾
    String  update(Book book);
    
    //����鱾
    String   add(Book book);
    
    //�޸Ŀ��
    void  updateRepertory(Book book) ;
   
}
