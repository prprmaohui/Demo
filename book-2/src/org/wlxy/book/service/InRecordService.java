package org.wlxy.book.service;

import java.util.Collection;
import java.util.Date;

import org.wlxy.book.vo.InRecord;

/**
 * @ClassName InRecordService
 * @Description TODO(入库记录Service层接口)
 * @author huangtao
 * @Date 2017年7月10日 下午2:17:56
 * @version 1.0.0
 */
public interface InRecordService {
    //入库记录信息添加 
    InRecord add (InRecord  inRecord);   
    
    //查询全量入库记录
    Collection<InRecord> queryAll(Date date);   
    //根据ID查询入库记录
    InRecord queryByID(String id );
    
    /**
     * 根据日期查找对应的入库记录
     * @param date
     * @return
     */
    Collection<InRecord> getAll(Date date);
   
}
