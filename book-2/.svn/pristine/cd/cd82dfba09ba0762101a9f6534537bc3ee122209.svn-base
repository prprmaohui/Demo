package org.wlxy.book.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import org.wlxy.book.vo.BookInRecord;
import org.wlxy.book.vo.Book;
import org.wlxy.book.commons.DateUtil;
import org.wlxy.book.dao.BookDao;
import org.wlxy.book.dao.BookInRecordDao;
import org.wlxy.book.dao.InRecordDao;
import org.wlxy.book.service.InRecordService;
import org.wlxy.book.vo.InRecord;

/**
 * @ClassName InRecordServiceImpl
 * @Description TODO(书本入库业务层实现)
 * @author huangato
 * @Date 2017年7月10日 下午3:43:34
 * @version 1.0.0
 */
public class InRecordServiceImpl implements InRecordService {

    private InRecordDao inRecordDao;
    private BookDao bookDao;
    private BookInRecordDao bookInRecordDao;

    // 构造方法
    public InRecordServiceImpl(InRecordDao inRecordDao, BookDao bookDao, BookInRecordDao bookInRecordDao) {
        this.inRecordDao = inRecordDao ;
        this.bookDao = bookDao;
        this.bookInRecordDao = bookInRecordDao ;
    }

    //添加入库记录
    @Override
    public InRecord add(InRecord inRecord) {
        String id = inRecordDao.save(inRecord);
        return inRecordDao.findByID(id);  
    }

    //根据ID查询入库记录
    @Override
    public InRecord queryByID(String id) {
        InRecord r = inRecordDao.findByID(id);
        return processData(r);    }

    //查询所有的入库记录
    @Override
    public Collection<InRecord> queryAll(Date date) {
        //得到下一天
        Date nextDate = DateUtil.getNextDate(date);
        //得到今天的日期, 格式为yyyy-MM-dd
        String today = DateUtil.getDateString(date);
        //得到明天的日期, 格式为yyyy-MM-dd
        String tomorrow = DateUtil.getDateString(nextDate);
        Collection<InRecord> records = inRecordDao.findByDate(today, tomorrow);
        for (InRecord r : records) {
            processData(r);
        }
        return records;
    }

  
   
    @Override
    public Collection<InRecord> getAll(Date date) {
        //得到下一天
        Date nextDate = DateUtil.getNextDate(date);
        //得到今天的日期, 格式为yyyy-MM-dd
        String today = DateUtil.getDateString(date);
        //得到明天的日期, 格式为yyyy-MM-dd
        String tomorrow = DateUtil.getDateString(nextDate);
        Collection<InRecord> records = inRecordDao.findByDate(today, tomorrow);
        for (InRecord r : records) {
            processData(r);
        }
        return records;
    }
    
    private InRecord processData(InRecord r) {
        Collection<BookInRecord> birs = bookInRecordDao.findByInRecord(r.getID());
        //设置记录中的每一本书
        setBook(birs);
        //设置入库记录中的书的入库记录
        r.setBookInRecords((Vector<BookInRecord>)birs);
        //设置书名
        r.setBookNames(getBookNames(birs));
        //设置书总数
        r.setAmount(getAmount(birs));
        return r;
    }
    
    //获取一次入库记录中所有书本的交易量
    private int getAmount(Collection<BookInRecord> birs) {
        int result = 0;
        for (BookInRecord br : birs) {
            result += Integer.valueOf(br.getIN_SUM());
        }
        return result;
    }
    
  //获取一次入库记录中所有书本的名字, 以逗号隔开
    private String getBookNames(Collection<BookInRecord> birs) {
        if (birs.size() == 0) return ""; 
        StringBuffer result = new StringBuffer();
        for (BookInRecord br : birs) {
            Book book = br.getBook();
            result.append(book.getBOOK_NAME() + ", ");
        }
        //去掉最后的逗号并返回
        return result.substring(0, result.lastIndexOf(","));
    }
    
  //设置参数中的每一个BookInRecord的book属性
    private void setBook(Collection<BookInRecord> birs) {
        for (BookInRecord bir : birs) {
            Book book = bookDao.findByID(bir.getBOOK_ID_FK());
            bir.setBook(book);
        }
    }
    
}
