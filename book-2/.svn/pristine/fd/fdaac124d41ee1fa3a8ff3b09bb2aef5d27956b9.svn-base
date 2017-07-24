package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.Book;

/**
 * @ClassName BookDao
 * @Description TODO(书本数据层dao)
 * @author huangtao
 * @Date 2017年7月10日 上午10:04:08
 * @version 1.0.0
 */
public interface BookDao {
  //查找全部的书本
    Collection<Book> findAll();
    
    //根据ID查找书本
     
    Book findByID(String id);
    
    //根据名称查询书本
    Collection<Book> findByName(String name);
    
    //修改书本
    String  update(Book book);
    
    //添加书本
    String   add(Book book);
    
    //修改库存
    void  updateRepertory(Book book) ;
   
}
