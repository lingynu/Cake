package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cake;

import java.util.List;

public interface CakeDAO {
    //前台
    //查询所有蛋糕的方法，只查询id，名字，图片，价格，返回一个蛋糕集合
    public List<Cake> listAllCake(int page,int count);
    //查询所有蛋糕数据条数
    public int getAllCountOfCake();
    //查询单个蛋糕，查询此蛋糕所有信息,查询完整的蛋糕信息
    public Cake listCake(int cakeId);
    //根据尺寸和口味查询到对应类型id，再根据类型id查询所有符合的蛋糕
    public List<Cake> listTypeCake(String size,String flavor);
    //根据折扣查询到对应折扣id,再根据折扣id查询所有符合的蛋糕
    public List<Cake> listSalesCake(String sales);
    //查询所有的折扣
    public List<Cake> listAllCountOfSales();
    //根据价格区间查询所有蛋糕
    public List<Cake> listPriceCake(double minPrice, double maxPrice);
    //根据名字查询蛋糕
    public List<Cake> listNameCake(String cakeName);
    //根据输入的值按蛋糕名字口味和尺寸进行模糊查找
    public List<Cake> listMoHuSearch(String mohuzhi);


    //后台
    public boolean addCake(Cake cake);
    public boolean updateCake(Cake cake);
    public boolean deleteCake(long cakeId);
}
