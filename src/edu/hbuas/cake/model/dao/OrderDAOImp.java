package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;
import edu.hbuas.cake.model.javabean.Order;
import edu.hbuas.cake.model.javabean.OrderDetail;
import edu.hbuas.cake.util.CreateOrderNumber;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImp extends BaseDAOImp implements OrderDAO{
    @Override
    public List<Order> listAllOrders(int userId) {
        List<Order> order=new ArrayList<>();
        String listOrderSQL = "select * from `order` o,address a where o.userId=? and o.addressId=a.id";
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
    public Order addOrder(Order order, List<OrderDetail> orderDetails) {
        Order result=null;

        int orderId=-1;
        String time=null;
        String addSQL="insert into `order`(creationTime,allPrice,status,userId,addressId) " +
                "values(CURRENT_TIMESTAMP(),?,?,?,?)";
        String addDetailsSQL="insert into orderdetails(number,commentStatus,cakeId,orderId) " +
                "values(?,0,?,?)";


        Connection con=getCon();

        System.out.println("进入添加订单DAO方法");
        try {

            con.setAutoCommit(false);
            PreparedStatement pre=con.prepareStatement(addSQL, Statement.RETURN_GENERATED_KEYS);
            pre.setBigDecimal(1, BigDecimal.valueOf(order.getAllPrice()));
            pre.setString(2,order.getStatus());
            pre.setInt(3,order.getUserId());
            pre.setInt(4,order.getAddress().getAddressId());
            pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();
            if(rs.next()){
                orderId = rs.getInt(1);
            }



            PreparedStatement secondpre=con.prepareStatement(addDetailsSQL);
            for(OrderDetail detail: orderDetails) {
                secondpre.setInt(1, detail.getNumber());
                secondpre.setInt(2, detail.getCake().getCakeId());
                secondpre.setInt(3, orderId);

                secondpre.executeUpdate();

            }
            con.commit();


//            con.setAutoCommit(true);
            Statement sta=con.createStatement();
            ResultSet timeRs=sta.executeQuery("select creationTime from `order` where id=" + orderId);
            if(timeRs.next()){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time = sdf.format(timeRs.getTimestamp(1));
            }
            System.out.println(time + "this is time");
            order.setOrderId(orderId);
            order.setCreationTime(time);
            result=order;
        } catch (Exception e){
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public boolean updateOrder(int orderId, String status) {
        boolean result=false;
        String updateSQL="update `order` set status=? where id=?";
        System.out.println("this is dao update: " + orderId);
        System.out.println("this is dao update: " + status);

        try{
            PreparedStatement pre=getPre(updateSQL);
            pre.setString(1,status);
            pre.setInt(2,orderId);


            result=pre.executeUpdate()>0?true:false;
//            getCon().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
