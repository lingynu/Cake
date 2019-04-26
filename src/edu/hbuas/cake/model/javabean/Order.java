package edu.hbuas.cake.model.javabean;

//这是订单类
public class Order {
    private int orderId;
    private String creationTime;
    private double allPrice;
    private String status;
    private int userId;
    //取address的名字，电话，地址，要在页面显示
    private Address address;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", creationTime='" + creationTime + '\'' +
                ", allPrice=" + allPrice +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", address=" + address +
                '}';
    }
}
