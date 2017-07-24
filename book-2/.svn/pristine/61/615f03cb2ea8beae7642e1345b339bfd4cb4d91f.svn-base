package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.BookType;

/**
 * @ClassName TypeDao
 * @Description TODO(书的类型数据映射dao接口)
 * @author huangtao
 * @Date 2017年7月10日 上午10:04:33
 * @version 1.0.0
 */
public interface BookTypeDao {
    
    //查找全部的书的类型
    Collection<BookType> findAll();
   
    //根据ID查找书的类型
     
    BookType findByID(String id);
    
    //根据名称查询书的类型
    Collection<BookType> findByName(String name);
    
    //修改书的类型
    String  update(BookType publisher);
    
    //添加书的类型
    String   save(BookType publisher);
        
}
