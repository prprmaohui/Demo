package org.wlxy.book.vo;


/**
 * @ClassName User
 * @Description TODO(用户表对象)
 * @author huangato
 * @Date 2017年7月5日 下午2:44:16
 * @version 1.0.0
 */
public class User extends ValueObject {
    //用户名
    private String USER_NAME;
    //密码
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
