package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;
import edu.hbuas.cake.model.javabean.Order;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImp extends BaseDAOImp implements OrderDAO{
    @Override
    public List<Order> listAllOrders(int userId) {
        List<Order> order=new ArrayList<>();
        String listOrderSQL = "select * from order o,address a where o.userId=? and o.addressId=a.id";
        try{
            PreparedStatement pre=getPre(listOrderSQL);
            pre.setInt(1,userId);
            ResultSet rs=pre.executeQuery();
            while (rs.next()){
                Order o=new Order();
                o.setOrderId(rs.getInt("o.id"));
                o.setCreationTime(rs.getString("o.creationTime"));
                o.setAllPrice(rs.getDouble("o.allPrice"));
                o.setStatus(rs.getString("o.status"));
                o.setUserId(rs.getInt("o.userId"));

                Address a=new Address();
                a.setAddressId(rs.getInt("o.addressId"));
                a.setName(rs.getString("a.name"));
                a.setPhone(rs.getString("a.phone"));
                a.setPlace(rs.getString("a.place"));
                a.setUserId(rs.getInt("o.userId"));

                o.setAddress(a);

                order.add(o);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean addOrder(Order order) {
        boolean result=false;
        String addSQL="insert into order(creationTime,allPrice,status,userId,addressId) " +
                "values(CURRENT_TIMESTAMP(),?,?,?,?)";
        try {
            PreparedStatement pre=getPre(addSQL);
            pre.setBigDecimal(2, BigDecimal.valueOf(order.getAllPrice()));
            pre.setString(3,order.getStatus());
            pre.setInt(4,order.getUserId());
            pre.setInt(5,order.getAddress().getAddressId());

            result=pre.executeUpdate()>0?true:false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateOrder(int orderId, String status) {
        return false;
    }
}
