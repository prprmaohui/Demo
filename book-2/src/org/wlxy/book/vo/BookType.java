package org.wlxy.book.vo;


/**
 * @ClassName Type
 * @Description TODO(������Ͷ���)
 * @author huangato
 * @Date 2017��7��5�� ����2:40:46
 * @version 1.0.0
 */
public class BookType extends ValueObject {
    //����   
    private String TYPE_NAME ;
     //���   
    private String TYPE_INTRO ;
    
    //�޲ι���
    public BookType() {
    }
    //�������Ĺ��췽��
    public BookType(String id, String type_name, String type_intro) {
        setID(id);
        TYPE_NAME = type_name;
        TYPE_INTRO = type_intro;
    }
   
    public String getTYPE_NAME() {
        return TYPE_NAME;
    }
    
    
    public void setTYPE_NAME(String tYPE_NAME) {
        TYPE_NAME = tYPE_NAME;
    }
    
    
    public String getTYPE_INTRO() {
        return TYPE_INTRO;
    }
    
   
    public void setTYPE_INTRO(String tYPE_INTRO) {
        TYPE_INTRO = tYPE_INTRO;
    }
}
