package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.InRecord;

/**
 * @ClassName InRecordDao
 * @Description TODO(书本入库数据层Dao接口)
 * @author huangtao
 * @Date 2017年7月10日 上午10:11:16
 * @version 1.0.0
 */
public interface InRecordDao {
    
    
    /**
     * 根据日期区间查找入库记录
     * @param begin 开始日期的字符串
     * @param end 结束日期的字符
     * @return
     */
    Collection<InRecord> findByDate(String begin, String end);
     
    
    //根据ID查找书本入库记录
     
    InRecord findByID(String id);
    
 
    //报存书本入库记录
    String   save(InRecord InRecord);
     
}
