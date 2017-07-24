package org.wlxy.book.service.impl;

import org.wlxy.book.commons.BusinessException;
import org.wlxy.book.dao.UserDao;
import org.wlxy.book.service.UserService;
import org.wlxy.book.vo.User;

/**
 * @ClassName UserServiceImpl
 * @Description TODO(用户service层实现类)
 * @author huangato
 * @Date 2017年7月10日 下午2:22:42
 * @version 1.0.0
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = null;

    // 构造方法
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 用户登录验证业务处理
    @Override
    public void login(String name, String password) {
      User loginUser= userDao.getUser(name, password);
      if(loginUser==null){
        //如果根据user对象的用户名和密码查询不到指定的用户记录，提示用户名密码错误
        throw new BusinessException("用户名或者密码错误!");
      }
    }

}
