package org.wlxy.book.vo;


/**
 * @ClassName Publisher
 * @Description TODO(����������Ӧ��ʵ��Publisher��)
 * @author huangato
 * @Date 2017��7��5�� ����2:35:25
 * @version 1.0.0
 */
public class Publisher extends ValueObject {

    //����������
    private String PUB_NAME;
    //������绰
    private String PUB_TEL;
    //��ϵ��
    private String PUB_LINK_MAN;
    //���
    private String PUB_INTRO;
    
    //�޲ι���
    public Publisher (){
        
    }
    //�������Ĺ��췽��
    public Publisher(String id, String pub_name, String pub_tel, String pub_link_man,
            String pub_intro) {
        setID_ID(id);
        PUB_NAME = pub_name;
        PUB_TEL = pub_tel;
        PUB_LINK_MAN = pub_link_man;
        PUB_INTRO = pub_intro;
    }

    public void setID_ID(String pUB_ID) {
    	String PUB_ID = pUB_ID;
	}
    
  
	public void setPUB_NAME(String pUB_NAME) {
        PUB_NAME = pUB_NAME;
    }
    
    public String getPUB_NAME() {
        return PUB_NAME;
    }
  
    public String getPUB_TEL() {
        return PUB_TEL;
    }
    
   
    public void setPUB_TEL(String pUB_TEL) {
        PUB_TEL = pUB_TEL;
    }
    
 
    public String getPUB_LINK_MAN() {
        return PUB_LINK_MAN;
    }
    
    
    public void setPUB_LINK_MAN(String pUB_LINK_MAN) {
        PUB_LINK_MAN = pUB_LINK_MAN;
    }
    
    
    public String getPUB_INTRO() {
        return PUB_INTRO;
    }
    
    
    public void setPUB_INTRO(String pUB_INTRO) {
        PUB_INTRO = pUB_INTRO;
    } 
    
}
