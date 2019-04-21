package edu.hbuas.cake.model.dao;

import java.util.List;
import edu.hbuas.cake.model.javabean.Cake;

public interface CakeDAO {
    //前台
    //查询所有蛋糕的方法，只查询id，名字，图片，价格，返回一个蛋糕集合
    public List<Cake> listAllCake();
    //查询单个蛋糕，查询此蛋糕所有信息,查询完整的蛋糕信息
    public Cake listCake(int cakeId);
    //根据尺寸和口味查询到对应类型id，再根据类型id查询所有符合类型的蛋糕
    public List<Cake> listAllCake(int size, String flavor);
    //根据价格区间查询所有蛋糕
    public List<Cake> listAllCake(double minPrice, double maxPrice);
    //根据名字查询蛋糕
    public List<Cake> listAllCake(String cakeName);


    //后台
    public boolean addCake(Cake cake);
    public boolean updateCake(Cake cake);
    public boolean deleteCake(int cakeId);
}
