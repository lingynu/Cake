package edu.hbuas.cake.model.dao;

//这是连接数据库的接口
public interface BaseDAO {
    public String url="jdbc:mysql://localhost:3306/food";
    public String username="root";
    public String password="123456";
    public String driverClass="com.mysql.jdbc.Driver";
}
