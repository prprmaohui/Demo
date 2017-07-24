package org.wlxy.book.dao.impl;

import java.util.Collection;
import java.util.Vector;

import org.wlxy.book.dao.BookSaleRecordDao;
import org.wlxy.book.vo.BookSaleRecord;
import org.wlxy.book.vo.SaleRecord;

/**
 * @ClassName BookSaleRecordDaoImpl
 * @Description TODO(�鱾���ۼ�¼DAOʵ����)
 * @author huangtao
 * @Date 2017��7��10�� ����10:45:07
 * @version 1.0.0
 */
public class BookSaleRecordDaoImpl extends CommonDaoImpl implements BookSaleRecordDao {

    // �������ۼ�¼��ȡȫ���鼮�����ۼ�¼����
    @Override
    public Collection<BookSaleRecord> findBySaleRecord(String saleRecord) {
//        String sql = "select * from T_BOOK_SALE_RECORD  TS  WHERE TS.BOOK_ID_FK = SALERECORDID.BOOK_ID_FK";
        String sql = "select * from T_BOOK_SALE_RECORD  TS  WHERE TS.T_SALE_RECORD_ID_FK = "+saleRecord;
//        return this.getDatas(sql, new Vector(), SaleRecord.class);
        return this.getDatas(sql, new Vector(), BookSaleRecord.class);
    }

    //�����鱾�����ۼ�¼
    @Override
    public String saveBookSaleRecord(BookSaleRecord bookSaleRecord) {
        String sql = "INSERT INTO T_BOOK_SALE_RECORD VALUES (ID, '" + bookSaleRecord.getBook().getID() + "', '"
                + bookSaleRecord.getT_SALE_RECORD_ID_FK() + "', '" + bookSaleRecord.getTRADE_SUM() + "')";
        return String.valueOf(getJDBCExecutor().executeUpdate(sql));
    }

}


