package com.imnu.login.Dao;

import com.imnu.login.bean.userBean;
import com.imnu.login.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {

    /**
     * 传入用户bean只有用户名和密码
     * 传出数据包含所有数据
     */

    public userBean login(userBean userbean) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from user where u_name = ? and u_pwd = ?;";
        userBean bean = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            bean = new userBean();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userbean.getU_name());
            pstm.setString(2, userbean.getU_pwd());
            rs = pstm.executeQuery();
            while (rs.next()) {
                bean.setU_name(rs.getString("u_name"));
                bean.setU_id(rs.getInt("u_id"));
                bean.setU_pwd(rs.getString("u_pwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeJDBC(conn, pstm, rs);
        }
        return bean;
    }
}
