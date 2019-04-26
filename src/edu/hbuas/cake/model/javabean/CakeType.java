package edu.hbuas.cake.model.javabean;

//这是蛋糕类型类
public class CakeType {
    private int cakeTypeId;
    private String size;
    private String flavor;

    public int getCakeTypeId() {
        return cakeTypeId;
    }

    public void setCakeTypeId(int cakeTypeId) {
        this.cakeTypeId = cakeTypeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "CakeType{" +
                "cakeTypeId=" + cakeTypeId +
                ", size='" + size + '\'' +
                ", flavor='" + flavor + '\'' +
                '}';
    }
}
