package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.OrderDetail;

import java.util.List;

public interface OrderDetailDAO {
    public List<OrderDetail> listAllOrderDetails(int orderId);
    //当生成一个订单可能会有多个订单详情项，将它们存在一个list集合里传给后台保存
//    public boolean addOrderDetails(List<OrderDetail> orderDetails);
    //当订单状态改变时改变订单详情的可评论状态
    public boolean updateOrderDetails(int detailsId, int commentStatus);
}
