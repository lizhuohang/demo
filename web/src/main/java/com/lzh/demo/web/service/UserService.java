package com.lzh.demo.web.service;

import com.lzh.demo.web.dao.UsersDAO;

/**
 * Created by lizhuohang on 17/1/18.
 */
public class UserService {
    private UsersDAO userDao;

    public int userCount(){
        return userDao.getAllUser().size();
    }

    public UsersDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UsersDAO userDao) {
        this.userDao = userDao;
    }
}
