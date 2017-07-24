package org.wlxy.book.dao;

import org.wlxy.book.vo.User;

/**
 * @ClassName
 * @Description TODO(用户数据层接口类)
 * @author huangtao
 * @Date 2017年7月10日 上午9:54:28
 * @version 1.0.0
 */
public interface UserDao {
    
    User getUser(String name ,String password);
}
