package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.CakeType;

import java.util.List;

public interface CakeTypeDAO {
    //前台
    public List<CakeType> listAllType();

    //后台

    public boolean addType(CakeType type);
    //删除时判断cake表里还有没有项引用此类型id，若有则提示无法删除
    public boolean deleteType(long typeId);
}
