package org.wlxy.book.vo;


/**
 * @ClassName User
 * @Description TODO(�û������)
 * @author huangato
 * @Date 2017��7��5�� ����2:44:16
 * @version 1.0.0
 */
public class User extends ValueObject {
    //�û���
    private String USER_NAME;
    //����
    private String USER_PASSWORD;
    
    /**
     * @return the uSER_NAME
     */
    public String getUSER_NAME() {
        return USER_NAME;
    }
    
    /**
     * @param uSER_NAME the uSER_NAME to set
     */
    public void setUSER_NAME(String uSER_NAME) {
        USER_NAME = uSER_NAME;
    }
    
    /**
     * @return the uSER_PASSWORD
     */
    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }
    
    /**
     * @param uSER_PASSWORD the uSER_PASSWORD to set
     */
    public void setUSER_PASSWORD(String uSER_PASSWORD) {
        USER_PASSWORD = uSER_PASSWORD;
    }
    
    
}
