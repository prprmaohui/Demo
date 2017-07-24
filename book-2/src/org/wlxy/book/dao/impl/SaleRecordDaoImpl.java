package org.wlxy.book.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.wlxy.book.dao.SaleRecordDao;
import org.wlxy.book.vo.SaleRecord;


/**
 * @ClassName SaleRecordDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author huangtao
 * @Date 2017年7月10日 上午10:44:21
 * @version 1.0.0
 */
public class SaleRecordDaoImpl extends CommonDaoImpl implements SaleRecordDao {

     
    @Override
    public Collection<SaleRecord> findByDate(String begin, String end) {
        String sql = "SELECT * FROM T_SALE_RECORD r WHERE " +
                "r.RECORD_DATE > '" + begin + "' AND r.RECORD_DATE < '" + end + "'";
        return getDatas(sql, new Vector(), SaleRecord.class);
    }

    @Override
    public SaleRecord findByID(String id) {
        String sql = "SELECT * FROM T_SALE_RECORD r WHERE r.ID='" + id + "'";
        List<SaleRecord> list = (List<SaleRecord>)getDatas(sql, new ArrayList(), 
                SaleRecord.class);
        return list.size() == 0 ? null : list.get(0);
    }
    
    public String save(SaleRecord r) {
        String sql = "INSERT INTO T_SALE_RECORD VALUES(ID, '" + r.getRECORD_DATE() + "')";
        return String.valueOf(getJDBCExecutor().executeUpdate(sql));
    }

   

}
