package edu.hbuas.cake.control;

import edu.hbuas.cake.model.dao.AddressDAOImp;
import edu.hbuas.cake.model.javabean.Address;
import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.Cart;
import edu.hbuas.cake.model.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddressServlet",urlPatterns = "/AddressServlet")
public class AddressServlet extends HttpServlet {

    private AddressDAOImp addressDAOImp;

    @Override
    public void init() throws ServletException {
        addressDAOImp = new AddressDAOImp();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        switch (method){
            case "payment" : {
                payment(request,response);
                break;
            }
            case "addAddress" : {
                addAddress(request,response);
                break;
            }
            case "updateAddresss":{
                updateAddresss(request,response);
                break;
            }
            case "deleteAddress":{
                deleteAddress(request,response);
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



    private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到了payment方法了");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if (user==null){
            System.out.println("用户为登录，请先去完成登录");
            response.sendRedirect("login.jsp");

        }else {
            System.out.println("进入到了要获取list了");
            List<Address> list = addressDAOImp.listAllAddress(user.getUserId());
            System.out.println(list);
            session.setAttribute("allAddress",list);
            //获取订单所需要的值

            Cart cart = (Cart)session.getAttribute("cart");
            System.out.println(cart);
            //获取到所有的购物项，有cake这个对象，这里获取到的是一个数组
            cart.getMap().values();

            System.out.println(cart.getMap().values());
            //这里是要传给订单的总价
            cart.getPrice();

            System.out.println(cart.getPrice());

            request.getRequestDispatcher("address.jsp").forward(request,response);
            //进入收货地址页面，从数据库中查找用户所有的地址，在此页面对地址进行增删改查操作。
        }
    }

    private void updateAddresss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到了修改的方法");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int userId = user.getUserId();

        int addressId = Integer.parseInt(request.getParameter("addressId")) ;
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String place = request.getParameter("place");

        Address address = new Address();
        address.setUserId(userId);
        address.setAddressId(addressId);
        address.setAddressName(name);
        address.setPhone(phone);
        address.setPlace(place);
        System.out.println(address);

        try{
            boolean result = addressDAOImp.updateAddress(address);
            if (result){
                System.out.println("修改成功");
                request.getRequestDispatcher("/AddressServlet?method=payment").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    }
    /**
     * 这里是添加收货地址的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String place = request.getParameter("place");

        System.out.println(place);

        User user = (User)session.getAttribute("user");
        int userId = user.getUserId();

        Address address = new Address();

        address.setUserId(userId);
        address.setPlace(place);
        address.setPhone(phone);
        address.setAddressName(name);

        System.out.println(address);
        try{
            boolean result = addressDAOImp.addAddress(address);
            if (result){
                System.out.println("添加成功");
                request.getRequestDispatcher("/AddressServlet?method=payment").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    }

    private void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到删除的方法了");

        String addressId = request.getParameter("addressId");

        try{
            boolean result = addressDAOImp.deleteAddress(Integer.parseInt(addressId));
            if (result){
                System.out.println("删除成功");
                request.getRequestDispatcher("/AddressServlet?method=payment").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    }
}
