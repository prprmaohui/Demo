package org.wlxy.book.vo;

import java.util.Vector;

import org.wlxy.book.vo.BookInRecord;

/**
 * @ClassName InRecord
 * @Description TODO(����¼��)
 * @author huangato
 * @Date 2017��7��5�� ����2:53:41
 * @version 1.0.0
 */

public class InRecord extends ValueObject {
 

    private String RECORD_DATE; //�������
    
    //����������
    private int amount;
    
    //������¼����Ӧ���������¼
    private Vector<BookInRecord> bookInRecords;
    
    //����������, �Զ��Ÿ���
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
