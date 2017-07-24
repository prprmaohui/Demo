package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.SaleRecord;

/**
 * @ClassName SaleRecordDao
 * @Description TODO(销售记录数据层dao接口)
 * @author huangtao
 * @Date 2017年7月10日 上午10:11:58
 * @version 1.0.0
 */
public interface SaleRecordDao {
   
    /**
     * 根据两个日期, 查找两个日期之间的交易记录
     * @param begin 开始日期的字符串, 格式为yyyy-MM-dd
     * @param end 结束日期的字符串, 格式为yyyy-MM-dd
     * @return
     */
    Collection<SaleRecord> findByDate(String begin, String end);

    
    //根据ID查找销售记录   
    SaleRecord findByID(String id);
    
 
    //添加销售记录
    String  save (SaleRecord saleRecord);
}
