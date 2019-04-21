package edu.hbuas.cake.model.javabean;

//这是蛋糕对象类
public class Cake {
    private int cakeId;
    private String cakeName;
    private String imageUrl;
    private double price;
    private int stock;
    private String sales;
    private String describe;
    /**
     *
     */
    private CakeType type;

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public CakeType getType() {
        return type;
    }

    public void setType(CakeType type) {
        this.type=type;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "cakeId=" + cakeId +
                ", cakeName='" + cakeName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales='" + sales + '\'' +
                ", describe='" + describe + '\'' +
                ", type=" + type +
                '}';
    }
}
