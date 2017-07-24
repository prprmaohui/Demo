package org.wlxy.book.dao.impl;

import java.util.Collection;
import java.util.Vector;

import org.wlxy.book.dao.BookInRecordDao;
import org.wlxy.book.vo.BookInRecord;

/**
 * @ClassName BookInRecordDaoImpl
 * @Description TODO(书本入库记录实现类)
 * @author huangtao
 * @Date 2017年7月10日 上午10:46:15
 * @version 1.0.0
 */
public class BookInRecordDaoImpl extends CommonDaoImpl implements BookInRecordDao {

    @Override
    public Collection<BookInRecord> findByInRecord(String inRecordId) {
        String sql = "SELECT * FROM T_BOOK_IN_RECORD r WHERE r.T_IN_RECORD_ID_FK='" + 
        inRecordId + "'";
        return getDatas(sql, new Vector(), BookInRecord.class);
    }

    @Override
    public String save(BookInRecord r) {
        String sql = "INSERT INTO T_BOOK_IN_RECORD VALUES (ID, '" + r.getBook().getID() + 
        "', '" + r.getT_IN_RECORD_ID_FK() + "', '" + r.getIN_SUM() + "')";
        return String.valueOf(getJDBCExecutor().executeUpdate(sql));
    }

  
    @Override
    public Collection<BookInRecord> findByDate(String begin, String end) {
        // TODO Auto-generated method stub
        return null;
    }

   
    @Override
    public BookInRecord findByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
