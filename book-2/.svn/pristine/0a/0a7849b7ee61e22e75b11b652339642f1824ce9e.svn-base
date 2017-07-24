package org.wlxy.book.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.wlxy.book.dao.BookDao;
import org.wlxy.book.vo.Book;


/**
 * @ClassName BookDaoImpl
 * @Description TODO(书本数据层dao实现类)
 * @author huangtao
 * @Date 2017年7月10日 上午10:38:27
 * @version 1.0.0
 */
public class BookDaoImpl extends CommonDaoImpl implements BookDao {

   
    @Override
    public Collection<Book> findAll() {
        String sql = "SELECT * FROM T_BOOK book ORDER BY book.ID desc";
        return getDatas(sql, new Vector(), Book.class);
    }

   
    @Override
    public Book findByID(String id) {
        String sql = "SELECT * FROM T_BOOK book WHERE book.ID='" + id + "'";
        List<Book> datas =  (List<Book>)getDatas(sql, new ArrayList(), Book.class);
        return datas.get(0);
    }

  
    @Override
    public Collection<Book> findByName(String name) {
        String sql = "SELECT * FROM T_BOOK book WHERE book.BOOK_NAME like '%" + name 
                + "%'" + " ORDER BY book.ID DESC";
                return getDatas(sql, new Vector(), Book.class);
    }

   
    @Override
    public String update(Book book) {
        String sql = "UPDATE T_BOOK book SET book.BOOK_NAME='" + book.getBOOK_NAME() + 
                "', book.BOOK_INTRO='" + book.getBOOK_INTRO() + "', book.BOOK_PRICE='" + 
                book.getBOOK_PRICE() + "', book.TYPE_ID_FK='" + book.getTYPE_ID_FK() + 
                "', book.PUB_ID_FK='" + book.getPUB_ID_FK() + "', book.IMAGE_URL='" + 
                book.getIMAGE_URL() + "', book.AUTHOR='" + book + 
                "' WHERE book.ID='" + book.getID() + "'";
                getJDBCExecutor().executeUpdate(sql);
                return book.getID().toString();
    }

    
    @Override
    public String add(Book book) {
      //根据book对象拼装SQL
        String sql = "INSERT INTO T_BOOK VALUES (ID, '" + book.getBOOK_NAME() + "', '" + 
        book.getBOOK_INTRO() + "', '" + book.getBOOK_PRICE() + "', '" + book.getTYPE_ID_FK() + 
        "', '" + book.getPUB_ID_FK() + "', '" + book.getIMAGE_URL() + 
        "', '" + book.getAUTHOR() + "', '" + book.getREPERTORY_SIZE() + "')";
        //执行SQL并返回ID
        return String.valueOf(getJDBCExecutor().executeUpdate(sql));
    }
    
    //修改库存
    @Override
    public void updateRepertory(Book book) {
        String sql = "UPDATE T_BOOK book SET book.REPERTORY_SIZE='" + book.getREPERTORY_SIZE() + 
        "' WHERE book.ID='" + book.getID() + "'";
        getJDBCExecutor().executeUpdate(sql);
    }
}
