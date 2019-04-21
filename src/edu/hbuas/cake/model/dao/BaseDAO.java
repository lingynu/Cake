package edu.hbuas.cake.model.dao;

//这是连接数据库的接口
public interface BaseDAO {
    public String url="jdbc:mysql://127.0.0.1:3306/food?characterEncoding=UTF8";
    public String username="root";
    public String password="root";
    public String driverClass="com.mysql.jdbc.Driver";
}
