package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.BookSaleRecord;

/**
 * @ClassName BookSaleRecord
 * @Description TODO(���ۼ�¼���ݲ�dao�ӿ�)
 * @author huangtao
 * @Date 2017��7��10�� ����10:10:31
 * @version 1.0.0
 */
public interface BookSaleRecordDao {
    
 
    //������ۼ�¼
    String  saveBookSaleRecord (BookSaleRecord bookSaleRecord);
    
   //�������ۼ�¼id���������ۼ�¼����
    Collection<BookSaleRecord> findBySaleRecord(String saleRecordId);
}
