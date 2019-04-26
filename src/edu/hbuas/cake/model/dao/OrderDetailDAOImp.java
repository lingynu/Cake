package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.CakeType;
import edu.hbuas.cake.model.javabean.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImp extends BaseDAOImp implements OrderDetailDAO {
    @Override
    public List<OrderDetail> listAllOrderDetails(int orderId) {
        List<OrderDetail> details = new ArrayList<>();
        String listDetailsSQL = "select * from orderdetails d,cake c,caketype t " +
                "where d.orderId=? and d.cakeId=c.id and c.typeId=t.id";
        try{
            PreparedStatement pre = getPre(listDetailsSQL);
            pre.setInt(1,orderId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                OrderDetail detail = new OrderDetail();
                detail.setOrderDetailId(rs.getInt("d.id"));
                detail.setNumber(rs.getInt("d.number"));
                int st=rs.getInt("d.commentStatus");
                if(st==0)
                    detail.setCommentStatus("不可评论");
                else if (st==1)
                    detail.setCommentStatus("未评论");
                else if (st==2)
                    detail.setCommentStatus("已评论");
                detail.setOrderId(rs.getInt("d.orderId"));
                Cake cake = new Cake();
                cake.setCakeId(rs.getInt("c.id"));
                cake.setCakeName(rs.getString("c.name"));
                cake.setImageUrl(rs.getString("c.image"));
                cake.setPrice((rs.getBigDecimal("c.price")).doubleValue());
                CakeType type = new CakeType();
                type.setCakeTypeId(rs.getInt("t.id"));
                type.setFlavor(rs.getString("t.flavor"));
                type.setSize(rs.getString("t.size"));
                cake.setType(type);
                detail.setCake(cake);

                details.add(detail);

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return details;
    }

//    @Override
//    public boolean addOrderDetails(List<OrderDetail> orderDetails) {
//        boolean result=false;
//        String addDetailsSQL="insert into orderdetails(number,commentStatus,cakeId,orderId) " +
//                "values(?,0,?,?)";
//        try{
//            PreparedStatement pre=getPre(addDetailsSQL);
//            for(OrderDetail detail: orderDetails){
//                pre.setInt(1,detail.getNumber());
//                pre.setInt(3,detail.getCake().getCakeId());
//                pre.setInt(4,detail.getOrderId());
//
//                result=pre.executeUpdate()>0?true:false;
//                if(result==false)
//                    break;
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return result;
//    }

    @Override
    public boolean updateOrderDetails(int detailsId, int commentStatus) {
        boolean result=false;
        String updateDetailsSQL="update orderdetails set commentStatus=? where id=?";
        try{
            PreparedStatement pre=getPre(updateDetailsSQL);
            pre.setInt(1,commentStatus);
            pre.setInt(2,detailsId);

            result=pre.executeUpdate()>0?true:false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
