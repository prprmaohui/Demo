package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.BookInRecord;
import org.wlxy.book.vo.SaleRecord;

/**
 * @ClassName Book_in_record
 * @Description TODO(书本入库记录数据层dao)
 * @author huangtao
 * @Date 2017年7月10日 上午10:08:42
 * @version 1.0.0
 */
public interface BookInRecordDao {

    /**
     * 根据两个日期, 查找两个日期之间的交易记录
     * @param begin 开始日期的字符串, 格式为yyyy-MM-dd
     * @param end 结束日期的字符串, 格式为yyyy-MM-dd
     * @return
     */
    Collection<BookInRecord> findByDate(String begin, String end);

    
    //根据ID查找入库记录   
    BookInRecord findByID(String id);
    
 
    //添加销售记录
    String  save (BookInRecord bookInRecord);
    
    //根据入库记录查找全部的书的入库记录
    Collection<BookInRecord> findByInRecord(String inRecordId);
    
}
