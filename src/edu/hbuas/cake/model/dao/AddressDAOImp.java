package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;
import edu.hbuas.cake.model.javabean.Cake;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImp extends BaseDAOImp implements AddressDAO {

    @Override
    public List<Address> listAllAddress(int userId) {
        List<Address> cs=new ArrayList<>();
        try {
            PreparedStatement pre = getPre("select * from address where userId=?");
            pre.setInt(1,userId);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Address address=new Address();
                address.setAddressId(rs.getInt("id"));
                address.setAddressName(rs.getString("name"));
                address.setPhone(rs.getString("phone"));
                address.setPlace(rs.getString("place"));
                address.setUserId(rs.getInt("userId"));
                cs.add(address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }

    @Override
    public Address listOneAddress(int addressId) {
        Address address=null;
        try {
            PreparedStatement pre=getPre("select *  from address where id=?");
            pre.setInt(1,addressId);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                address=new Address();
                address.setPlace(rs.getString("place"));
                address.setPhone(rs.getString("phone"));
                address.setAddressName(rs.getString("name"));
                address.setAddressId(rs.getInt("id"));
                address.setUserId(rs.getInt("userId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public boolean addAddress(Address address) {
        String sql = "insert into address(`name`,phone,place,userId) values(?,?,?,?)";
        boolean result = false;
        try{
            PreparedStatement pre = getPre(sql);
            pre.setString(1,address.getAddressName());
            pre.setString(2,address.getPhone());
            pre.setString(3,address.getPlace());
            pre.setInt(4,address.getUserId());

            result=pre.executeUpdate()>0?true:false;

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return result;
        }

    }

    @Override
    public boolean updateAddress(Address address) {
        String sql = "update address set name=?,phone=?,place=? where id=?";
        boolean result=false;
        try{
            PreparedStatement pre = getPre(sql);
            pre.setString(1,address.getAddressName());
            pre.setString(2,address.getPhone());
            pre.setString(3,address.getPlace());
            pre.setInt(4,address.getAddressId());
            result=pre.executeUpdate()>0?true:false;
            System.out.println(pre);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }

    @Override
    public boolean deleteAddress(int addressId) {
        String sql = "delete from address where id=?";
        boolean result = false;
        try{
            PreparedStatement pre = getPre(sql);
            pre.setInt(1,addressId);
            result=pre.executeUpdate()>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }
}
