package com.imnu.login.test;

import com.imnu.login.Dao.userDao;
import com.imnu.login.bean.userBean;

public class userdaoTest {
    public static void main(String[] args) {
        userDao userDao = new userDao();
        userBean userbean = new userBean();
        userbean.setU_name("xiaoming1");
        userbean.setU_pwd("123");
        userBean loginbean = userDao.login(userbean);
//        如果用户名不为空则搜索到结果
        if (loginbean.getU_name() != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
