package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImp extends BaseDAOImp implements AddressDAO{
    @Override
    public List<Address> listAllAddress(int userId) throws Exception{
        String listSQL="select * from address where userId=?";
        List<Address> addresses=new ArrayList<>();
        PreparedStatement pre=getPre(listSQL);
        pre.setInt(1,userId);
        ResultSet rs=pre.executeQuery();
        while (rs.next()){
            Address as=new Address();
            as.setAddressId(rs.getInt("id"));
            as.setName(rs.getString("name"));
            as.setPhone(rs.getString("phone"));
            as.setPlace(rs.getString("place"));
            as.setUserId(rs.getInt("userId"));
            addresses.add(as);
        }
        System.out.println("this is addressDAO  " + addresses);
        return addresses;
    }

    @Override
    public boolean addAddress(Address address) {
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return false;
    }
}
