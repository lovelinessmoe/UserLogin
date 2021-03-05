package com.imnu.login.servlet;

import com.imnu.login.Dao.userDao;
import com.imnu.login.bean.userBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置字符集
        request.setCharacterEncoding("utf-8");
        userBean userbean = new userBean();
        userbean.setU_name(request.getParameter("username"));
        userbean.setU_pwd(request.getParameter("password"));
        userDao userdao = new userDao();
        userBean loginbean = userdao.login(userbean);
        if (loginbean.getU_name() == null) {
//            登录失败
            request.getRequestDispatcher("/LoginFail").forward(request, response);
        } else {
//            登录成功
//            存储数据
            request.setAttribute("loginbean", loginbean);
//            转发
            request.getRequestDispatcher("/LoginSuccess").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
