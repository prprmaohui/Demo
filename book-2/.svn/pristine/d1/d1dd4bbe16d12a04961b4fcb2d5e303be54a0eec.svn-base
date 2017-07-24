package org.wlxy.book.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.wlxy.book.dao.UserDao;
import org.wlxy.book.vo.User;


/**
 * @ClassName UserDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author huangtao
 * @Date 2017年7月10日 上午10:44:02
 * @version 1.0.0
 */
public class UserDaoImpl extends CommonDaoImpl  implements UserDao{

    @Override
    public User getUser(String name, String password) {
        String sql = "SELECT * FROM T_USER user WHERE user.USER_NAME='" + name + "' and user.USER_PASSWORD='" + 
        password + "'";
        List<User> datas = (List<User>)getDatas(sql, new ArrayList(), User.class);
        return (datas.size() == 1) ? datas.get(0) : null;
    }

}
