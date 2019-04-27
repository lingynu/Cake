package food.model.dao;

import food.model.javabean.User;
import food.util.MD5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImp extends BaseDAOImp implements UserDAO {
    @Override
    public User login(String nickname, String password) {
        String loginSQL="select *  from  user where nickname=? and password=?";
        User u=null;
        System.out.println("查询到用户名和密码了！");
        System.out.println(nickname+","+password);
        try {
            PreparedStatement pre=getPre(loginSQL);
            pre.setString(1,nickname);
            pre.setString(2,password);
            ResultSet rs= pre.executeQuery();
            if(rs.next()) {
                u=new User();
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getString("sex"));
                u.setUserId(rs.getInt("id"));
                u.setNickname(rs.getString("nickname"));
                u.setHead(rs.getString("head"));
                u.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }


    @Override
    public boolean  reviseUserMessage(User user)
    {
        String password=null;
       String loginSQL="update user set name=?,nickname=?,head=?,password=?,sex=?,age=?,phone=? where id=?";
       boolean result=false;

       String newPassword=MD5.genertedPassword(MD5.addSoltToPassword(user.getNickname(),user.getPassword()));
       try{
            System.out.println("this is usernick:" +user.getNickname());
            System.out.println("this is pass:" +password);
            System.out.println("this is newpassword:" +newPassword);
            PreparedStatement pre=getPre(loginSQL);
            pre.setString(1,user.getName());
            pre.setString(2 ,user.getNickname());
            pre.setString(3 ,user.getHead());
            pre.setString(4 ,newPassword);
            pre.setString(5 ,user.getSex());
            pre.setLong(6,user.getAge());
            pre.setString(7,user.getPhone());
            pre.setLong(8,user.getUserId());
            result=pre.executeUpdate()>0?true:false;



        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }




    @Override
    public User login(String nickname) {
        String loginSQL="select *  from  user where nickname=?";
        User u=null;
        try {
            PreparedStatement pre=getPre(loginSQL);
            pre.setString(1,nickname);
            ResultSet rs= pre.executeQuery();
            if(rs.next()) {
                u=new User();
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getString("sex"));
                u.setUserId(rs.getInt("id"));
                u.setNickname(rs.getString("nickname"));
                u.setHead(rs.getString("head"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }


    public boolean register(User user) {
        String loginSQL="insert into user(name,nickname,password,head,sex,age,phone) values(?,?,?,?,?,?,?)";
        boolean result=false;
        try {
            PreparedStatement pre=getPre(loginSQL);
            pre.setString(1,user.getName());
            pre.setString(2 ,user.getNickname());
            pre.setString(3 ,user.getPassword());
            pre.setString(4 ,user.getHead());
            pre.setString(5 ,user.getSex());
            pre.setLong(6,user.getAge());
            pre.setString(7 ,user.getPhone());
            result=pre.executeUpdate()>0?true:false;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }




    @Override
    public boolean checkUserExists(String nickname) {
        String sql="select 1 from  user where nickname=?";
        boolean result=false;
        ResultSet rs=null;
        try {
            PreparedStatement pre=getPre(sql);
            pre.setString(1,nickname);
            rs=pre.executeQuery();
            result=rs.next()?true:false;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }



}
