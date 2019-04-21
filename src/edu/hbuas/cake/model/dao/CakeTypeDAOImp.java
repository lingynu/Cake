package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.CakeType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakeTypeDAOImp extends BaseDAOImp implements CakeTypeDAO {
    @Override
    public List<CakeType> listAllType() {
        List<CakeType> cs=new ArrayList<>();
        try {
            ResultSet rs=getSta().executeQuery("select * from cake");
            while(rs.next()){
                CakeType b=new CakeType();
                b.setCakeTypeId(rs.getInt("id"));
                b.setFlavor(rs.getString("flavor"));
                b.setSize(rs.getString("size"));
                cs.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cs;
    }

    @Override
    public boolean addType(CakeType type) {
        return false;
    }

    @Override
    public boolean deleteType(long typeId) {
        return false;
    }
}
