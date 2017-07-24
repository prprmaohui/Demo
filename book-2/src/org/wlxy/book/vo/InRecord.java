package org.wlxy.book.vo;

import java.util.Vector;

import org.wlxy.book.vo.BookInRecord;

/**
 * @ClassName InRecord
 * @Description TODO(入库记录类)
 * @author huangato
 * @Date 2017年7月5日 下午2:53:41
 * @version 1.0.0
 */

public class InRecord extends ValueObject {
 

    private String RECORD_DATE; //入库日期
    
    //入库的总数量
    private int amount;
    
    //该入库记录所对应的书的入库记录
    private Vector<BookInRecord> bookInRecords;
    
    //入库书的名称, 以逗号隔开
    private String bookNames;
    
    public String getRECORD_DATE() {
        return RECORD_DATE;
    }   
 
    public void setRECORD_DATE(String rECORD_DATE) {
        RECORD_DATE = rECORD_DATE;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Vector<BookInRecord> getBookInRecords() {
        return bookInRecords;
    }

    public void setBookInRecords(Vector<BookInRecord> bookInRecords) {
        this.bookInRecords = bookInRecords;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }

}
