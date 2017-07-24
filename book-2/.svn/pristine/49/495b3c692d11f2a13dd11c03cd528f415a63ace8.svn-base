package org.wlxy.book.vo;

/**
 * @ClassName BookInRecord
 * @Description TODO(书的入库记录类)
 * @author huangato
 * @Date 2017年7月5日 下午2:55:36
 * @version 1.0.0
 */
public class BookInRecord extends ValueObject {
    
    

    private String BOOK_ID_FK; //对应书的外键, 从数据库查出来时有值
    private String T_IN_RECORD_ID_FK; //对应销售记录外键
    private String IN_SUM; //入库数量  
    
    private Book book; //该记录所对应的书, 从数据库查出来时为null
    private InRecord inRecord; //该记录所对应的和库记录, 从数据库查出来时为null
    
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public InRecord getInRecord() {
        return inRecord;
    }

    public void setInRecord(InRecord inRecord) {
        this.inRecord = inRecord;
    }
    public String getBOOK_ID_FK() {
        return BOOK_ID_FK;
    }
    
    public void setBOOK_ID_FK(String bOOK_ID_FK) {
        BOOK_ID_FK = bOOK_ID_FK;
    }
      
    public String getT_IN_RECORD_ID_FK() {
        return T_IN_RECORD_ID_FK;
    }
      
    public void setT_IN_RECORD_ID_FK(String t_IN_RECORD_ID_FK) {
        T_IN_RECORD_ID_FK = t_IN_RECORD_ID_FK;
    }
    
   
    public String getIN_SUM() {
        return IN_SUM;
    }
    
   
    public void setIN_SUM(String iN_SUM) {
        IN_SUM = iN_SUM;
    }

}
