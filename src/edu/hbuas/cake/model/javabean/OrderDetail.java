package edu.hbuas.cake.model.javabean;

//这是订单详情类
public class OrderDetail {
    private int orderDetailId;
    private int number;
    private String commentStatus;
    //取cake的名字，id，价格，类型，图片
    private Cake cake;
    private int orderId;

    public OrderDetail() {
    }


    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", number=" + number +
                ", commentStatus=" + commentStatus +
                ", cake=" + cake +
                ", orderId=" + orderId +
                '}';
    }
}
