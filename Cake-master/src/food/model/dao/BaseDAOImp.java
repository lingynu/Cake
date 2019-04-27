package food.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

//这是连接数据库接口的实现类
public class BaseDAOImp implements BaseDAO{
    private Connection con;
    private PreparedStatement pre;
    private Statement sta;

    public Connection getCon(){
        try{
            Class.forName(driverClass);
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public PreparedStatement getPre(String sql){
        if(con == null){
            con = getCon();
        }
        try{
            pre = con.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return pre;
    }

    public Statement getSta(){
        if(con == null){
            con = getCon();
        }
        try{
            sta = con.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return sta;
    }

    public void disposeResource(Connection con, Statement sta, PreparedStatement pre, ResultSet rs){

    }

}
