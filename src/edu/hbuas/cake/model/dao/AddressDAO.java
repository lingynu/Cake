package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;

import java.util.List;

public interface AddressDAO {
    //根据用户id查询出此用户的所有地址信息
    public List<Address> listAllAddress(long userId);
    public boolean addAddress(Address address);
    public boolean updateAddress(Address address);
    public boolean deleteAddress(long addressId);
}
