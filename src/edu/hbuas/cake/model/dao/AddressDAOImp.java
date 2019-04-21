package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Address;

import java.util.List;

public class AddressDAOImp extends BaseDAOImp implements AddressDAO {
    @Override
    public List<Address> listAllAddress(long userId) {
        return null;
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
    public boolean deleteAddress(long addressId) {
        return false;
    }
}
