package food.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class BaseDAOImp implements BaseDAO{
    private Connection con;
    private PreparedStatement pre;
    private Statement sta;
    public Connection getCon(){
        if (con==null){
            openConnection();
        }
        return con;
    }
    public Statement getSta(){
        if (sta==null){
            try{
                sta=getCon().createStatement();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return sta;
    }
    public PreparedStatement getPreSta(String sql) {
        if(pre==null) {
            try {
                pre = getCon().prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pre;
    }
    private void openConnection(){
        try {
            Class.forName(driverClass);
            con= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BaseDAOImp(){
        openConnection();
    }
    public void disposeResource(ResultSet rs,Statement sta,PreparedStatement pre,Connection con){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(pre!=null){
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
