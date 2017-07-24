package org.wlxy.book.service.impl;

import java.util.Collection;

import org.wlxy.book.dao.BookTypeDao;
import org.wlxy.book.service.BookTypeService;
import org.wlxy.book.vo.BookType;

/**
 * @ClassName BookTypeImpl
 * @Description TODO(书本类型业务层实现)
 * @author huangato
 * @Date 2017年7月10日 下午3:42:19
 * @version 1.0.0
 */
public class BookTypeServiceImpl implements BookTypeService {

    private BookTypeDao bookTypeDao;

    public BookTypeServiceImpl (BookTypeDao bookTypeDao){
        this.bookTypeDao = bookTypeDao;
    }
     
    @Override
    public Collection<BookType> findAll() {
        return bookTypeDao.findAll();
    }

    @Override
    public BookType findByID(String id) {
        return bookTypeDao.findByID(id);
    }

    @Override
    public Collection<BookType> findByName(String name) {
        return bookTypeDao.findByName(name);
    }

    @Override
    public BookType update(BookType bookType) {

        String id = bookTypeDao.update(bookType);
        return bookTypeDao.findByID(id);
    }

    @Override
    public BookType add(BookType bookType) {
        String id = bookTypeDao.save(bookType);
        return bookTypeDao.findByID(id);
    }

}
