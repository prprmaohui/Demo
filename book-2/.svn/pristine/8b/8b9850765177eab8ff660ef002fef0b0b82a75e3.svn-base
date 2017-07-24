package org.wlxy.book.vo;


/**
 * @ClassName Book
 * @Description TODO(书本对象)
 * @author huangato
 * @Date 2017年7月5日 下午2:47:36
 * @version 1.0.0
 */
public class Book extends ValueObject {
 
    private String BOOK_NAME; //书本名称
    private String BOOK_INTRO; //简介
    private String BOOK_PRICE; //书的单价
    private String TYPE_ID_FK; //种类外键
    private String PUB_ID_FK; //出版社外键
    private String REPERTORY_SIZE; //存储量
    private String IMAGE_URL; //图片url
    private String AUTHOR;//书本的作者
    //书本类型对象
    private BookType bookType ;
    //出版社类型对象
    private Publisher publisher ;
    
    public Book(){
        
    }
    //带参数的构造方法
    public Book(String id, String book_name, String book_intro, String book_price,
            String type_id_fk, String pub_id_fk, String repertory_size, 
            String image_url, String author) {
        setID(id);
        BOOK_NAME = book_name;
        BOOK_INTRO = book_intro;
        BOOK_PRICE = book_price;
        TYPE_ID_FK = type_id_fk;
        PUB_ID_FK = pub_id_fk;
        REPERTORY_SIZE = repertory_size;
        IMAGE_URL = image_url;
        AUTHOR = author;
    }

    
    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

 
    public void setBOOK_NAME(String bOOK_NAME) {
        BOOK_NAME = bOOK_NAME;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String aUTHOR) {
        AUTHOR = aUTHOR;
    }

    
    public String getBOOK_NAME() {
        return BOOK_NAME;
    }
    
   
    public void setBook_name(String bOOK_NAME) {
        BOOK_NAME = bOOK_NAME;
    }
    
    public String getBOOK_INTRO() {
        return BOOK_INTRO;
    }
    
    
    public void setBOOK_INTRO(String bOOK_INTRO) {
        BOOK_INTRO = bOOK_INTRO;
    }
    
   
    public String getBOOK_PRICE() {
        return BOOK_PRICE;
    }
    
  
    public void setBOOK_PRICE(String bOOK_PRICE) {
        BOOK_PRICE = bOOK_PRICE;
    }
    
  
    public String getTYPE_ID_FK() {
        return TYPE_ID_FK;
    }
    
    
    public void setTYPE_ID_FK(String tYPE_ID_FK) {
        TYPE_ID_FK = tYPE_ID_FK;
    }
   
    public String getPUB_ID_FK() {
        return PUB_ID_FK;
    }
    
   
    public void setPUB_ID_FK(String pUB_ID_FK) {
        PUB_ID_FK = pUB_ID_FK;
    }
    
   
    public String getREPERTORY_SIZE() {
        return REPERTORY_SIZE;
    }
    
    
    public void setREPERTORY_SIZE(String rEPERTORY_SIZE) {
        REPERTORY_SIZE = rEPERTORY_SIZE;
    }
    
   
    public String getIMAGE_URL() {
        return IMAGE_URL;
    }
    
  
    public void setIMAGE_URL(String iMAGE_URL) {
        IMAGE_URL = iMAGE_URL;
    }
  

}
