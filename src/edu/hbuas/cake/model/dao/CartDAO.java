package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cart;
import edu.hbuas.cake.model.javabean.CartItem;

import java.util.List;
import java.util.Map;

public interface CartDAO {
    //添加购物车条目
    public boolean addCartItem(CartItem cartItem);

    //判断用户是否存在此商品
    public boolean isExists(int userId , int cakeId);

    //更新商品条目数量
    public int updateCartItemCount(CartItem cartItem);

    //根据用户id获取购物车条目信息，返回一个购物车集合
    public Map<Integer,CartItem> getCartItem(int userId);

    //删除一条购物车条目
    public CartItem findCartItemById(int userId,int cakeId);

    //清空购物车条目
    public boolean deleteAllCartItem(int userId);

}
