package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImp  extends BaseDAOImp implements UserDAO {
    @Override
    public User login(long userId, String password) {
        String loginSQL = "select * from user where id=? and password=?";
        User u = null;
        try{
            PreparedStatement pre = getPre(loginSQL);
            pre.setLong(1,userId);
            pre.setString(2,password);
            ResultSet rs = pre.executeQuery();
            if(rs.next()) {
                u = new User();
                u.setUserId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                u.setNickname(rs.getString("nickname"));
                u.setHead(rs.getString("head"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setPhone(rs.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    //在判断cookie里有用户数据时，只根据用户id登录
    @Override
    public User login(long userId) {
        return null;
    }

    //注册方法，注册成功时返回注册的用户id字符串，失败返回"false"字符串
    @Override
    public String register(User user) {
        return "false";
    }
}
