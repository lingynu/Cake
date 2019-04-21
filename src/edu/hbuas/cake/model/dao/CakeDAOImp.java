package edu.hbuas.cake.model.dao;
import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.CakeType;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakeDAOImp extends BaseDAOImp implements CakeDAO {

    @Override
    public int getAllCountOfCake() {
        int result=0;
        ResultSet rs=null;
        try {
            rs=getSta().executeQuery("select count(id) from cake");
            rs.next();
            result=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Cake> listAllCake(int page,int count) {
        List<Cake> cs=new ArrayList<>();
        try {
            ResultSet rs=getSta().executeQuery("select id,name,price,image  from cake limit "+(page-1)*count+","+count);
            while(rs.next()){
                Cake b=new Cake();
                b.setCakeId(rs.getInt("id"));
                b.setCakeName(rs.getString("name"));
                b.setPrice(rs.getDouble("price"));
                b.setImageUrl(rs.getString("image"));
                cs.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }


    public Cake listCake(int cakeId) {
        System.out.println(cakeId);
        Cake c=null;
        CakeType t=null;
        try {
            PreparedStatement pre=getPre("select *  from cake,caketype where cake.id=? and cake.typeId=caketype.id");
            pre.setInt(1,cakeId);
            ResultSet rs=pre.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                t=new CakeType();
                t.setCakeTypeId(rs.getInt("caketype.id"));
                t.setSize(rs.getString("caketype.size"));
                t.setFlavor(rs.getString("caketype.flavor"));
                c=new Cake();
                c.setCakeId(cakeId);
                c.setCakeName(rs.getString("name"));
                c.setImageUrl(rs.getString("image"));
                c.setPrice(rs.getDouble("price"));
                c.setStock(rs.getInt("stock"));
                c.setSales(rs.getString("sales"));
                c.setDescribe(rs.getString("describe"));
                c.setType(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<Cake> listTypeCake(String size,String flavor){
        List<Cake> cs=new ArrayList<>();
        try {
            if (size==null&&flavor==null){
                System.out.println("没有选择尺寸和口味");
            }
            else if (size==null){
                PreparedStatement pre=getPre("select cake.id,name,price,image  from cake,caketype where caketype.flavor=? and cake.typeId=caketype.id");
                pre.setString(1,flavor);
                ResultSet rs=pre.executeQuery();
                while(rs.next()){
                    Cake b=new Cake();
                    b.setCakeId(rs.getInt("id"));
                    b.setCakeName(rs.getString("name"));
                    b.setPrice(rs.getDouble("price"));
                    b.setImageUrl(rs.getString("image"));
                    cs.add(b);
                }
                }
            else if (flavor==null){
                PreparedStatement pre=getPre("select cake.id,name,price,image  from cake,caketype where caketype.size=? and cake.typeId=caketype.id");
                pre.setString(1,size);
                ResultSet rs=pre.executeQuery();
                while(rs.next()){
                    Cake b=new Cake();
                    b.setCakeId(rs.getInt("id"));
                    b.setCakeName(rs.getString("name"));
                    b.setPrice(rs.getDouble("price"));
                    b.setImageUrl(rs.getString("image"));
                    cs.add(b);
                }
            }else {
                PreparedStatement pre = getPre("select cake.id,name,price,image  from cake,caketype where caketype.size=? and caketype.flavor=? and cake.typeId=caketype.id");
                pre.setString(1, size);
                pre.setString(2, flavor);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    Cake b = new Cake();
                    b.setCakeId(rs.getInt("id"));
                    b.setCakeName(rs.getString("name"));
                    b.setPrice(rs.getDouble("price"));
                    b.setImageUrl(rs.getString("image"));
                    cs.add(b);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;

    }

    @Override
    public List<Cake> listPriceCake(double minPrice, double maxPrice) {
        List<Cake> cs=new ArrayList<>();
        CakeType t=new CakeType();
        try {
            ResultSet rs=getSta().executeQuery("select *  from cake,caketype where price between minPrice and maxPrice and cake.typeId=caketype.id");
            t.setCakeTypeId(rs.getInt("id"));
            t.setSize(rs.getString("size"));
            t.setFlavor(rs.getString("flavor"));
            while(rs.next()){
                Cake c=new Cake();
                c.setCakeId(rs.getInt("id"));
                c.setCakeName(rs.getString("name"));
                c.setImageUrl(rs.getString("image"));
                c.setPrice(rs.getDouble("price"));
                c.setStock(rs.getInt("stock"));
                c.setSales(rs.getString("sales"));
                c.setDescribe(rs.getString("describe"));
                c.setType(t);
                cs.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }

    @Override
    public List<Cake> listNameCake(String cakeName) {
        List<Cake> cs = new ArrayList<>();
        CakeType t = new CakeType();
        try {
            ResultSet rs = getSta().executeQuery("select *  from cake,caketype where caketype.size=size and cake.typeId=caketype.id");
            t.setCakeTypeId(rs.getInt("id"));
            t.setSize(rs.getString("size"));
            t.setFlavor(rs.getString("flavor"));
            while (rs.next()) {
                Cake c = new Cake();
                c.setCakeId(rs.getInt("id"));
                c.setCakeName(rs.getString("name"));
                c.setImageUrl(rs.getString("image"));
                c.setPrice(rs.getDouble("price"));
                c.setStock(rs.getInt("stock"));
                c.setSales(rs.getString("sales"));
                c.setDescribe(rs.getString("describe"));
                c.setType(t);
                cs.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }
    @Override
    public boolean addCake(Cake cake) {
        return false;
    }

    @Override
    public boolean updateCake(Cake cake) {
        return false;
    }

    @Override
    public boolean deleteCake(long cakeId) {
        return false;
    }


}
