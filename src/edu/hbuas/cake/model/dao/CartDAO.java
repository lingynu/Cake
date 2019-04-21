package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cart;

import java.util.List;

public interface CartDAO {
    //根据用户id取到他的购物车信息，返回一个购物车集合，每个购物车类里应存储一个cake对象，只设置名字，id，类型的值
    public List<Cart> listAllCart(int userId);
    //添加cookie里保存的购物车信息到数据库
    public boolean addCartToCookie(List<Cart> cookieCart);
    //已登录账户时添加一条购物车信息到数据库
    public boolean addCart(Cart cart);
    //根据购物车id更改信息，只允许更改数量
    public boolean updateCart(int cartId, int number);
    //删除一条或多条购物车信息
    public boolean deleteCart(int[] cartId);
    //清空购物车
    public boolean deleteAllCart(int userId);
}
