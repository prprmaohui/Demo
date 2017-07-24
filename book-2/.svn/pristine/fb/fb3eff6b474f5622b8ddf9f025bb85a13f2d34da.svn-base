package org.wlxy.book.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.wlxy.book.dao.InRecordDao;
import org.wlxy.book.vo.InRecord;


/**
 * @ClassName InRecordDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author huangtao
 * @Date 2017年7月10日 上午10:44:43
 * @version 1.0.0
 */
public class InRecordDaoImpl  extends CommonDaoImpl implements InRecordDao {
   
    @Override
    public Collection<InRecord> findByDate(String begin, String end) {
        String sql = "SELECT * FROM T_IN_RECORD r WHERE " +
        "r.RECORD_DATE > '" + begin + "' AND r.RECORD_DATE < '" + end + "'";
        return getDatas(sql, new Vector(), InRecord.class);
    }

    @Override
    public InRecord findByID(String id) {
        String sql = "SELECT * FROM T_IN_RECORD r WHERE r.ID='" + id + "'";
        List<InRecord> datas = (List<InRecord>)getDatas(sql, new ArrayList(), InRecord.class);
        return (datas.size() == 1) ? datas.get(0) : null;
    }

    @Override
    public String save(InRecord r) {
        String sql = "INSERT INTO T_IN_RECORD VALUES(ID, '" + r.getRECORD_DATE() + "')";
        return String.valueOf(getJDBCExecutor().executeUpdate(sql));
    }
}
