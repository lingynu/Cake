package edu.hbuas.cake.control;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.hbuas.cake.model.dao.OrderDAO;
import edu.hbuas.cake.model.dao.OrderDAOImp;
import edu.hbuas.cake.model.dao.OrderDetailDAO;
import edu.hbuas.cake.model.dao.OrderDetailDAOImp;
import edu.hbuas.cake.model.javabean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderDetailDAO detailDAO;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAOImp();
        detailDAO = new OrderDetailDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println("ssssss");
        switch(method){
            case "submitOrder":{
                submitOrder(request,response);
                break;
            }
            case "addOrder":{
                addOrder(request,response);
            }
            case "updateOrder":{
                updateOrder(request,response);
            }
            case "listOrderDetails":{
                listOrderDetails(request,response);
            }
            case "listOrders":{
                listOrders(request,response);
            }
            case "payOrder":{
                payOrder(request,response);
            }
        }
    }

    protected void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userId=request.getParameter("userId");
        String addressId=request.getParameter("addressId");
        String allPrice=request.getParameter("allPrice");
        String cakeIds=request.getParameter("cakeIds");
        String cakeNumber=request.getParameter("cakeNumber");
        System.out.println(userId);
        System.out.println(addressId);
        System.out.println(allPrice);
        System.out.println(cakeIds);
        System.out.println(cakeNumber);

        Order order=new Order();
        order.setAllPrice(Double.valueOf(allPrice));
        order.setStatus("未付款");
        order.setUserId(Integer.parseInt(userId));
        order.setAddress(new Address(Integer.parseInt(addressId)));

        String[] cakeIdStr=cakeIds.split(",");
        String[] numberStr=cakeNumber.split(",");

        if(cakeIdStr.length==numberStr.length){
            List<OrderDetail> orderDetails=new ArrayList<>();
            for(int i=0; i<cakeIdStr.length; i++){
                OrderDetail detail=new OrderDetail();
                detail.setNumber(Integer.parseInt(numberStr[i]));
                detail.setCake(new Cake(Integer.parseInt(cakeIdStr[i])));
                orderDetails.add(detail);
            }
            System.out.println(order);
            System.out.println(orderDetails);

            Order result=orderDAO.addOrder(order,orderDetails);
            System.out.println(result);
            if(result!=null){
                request.setAttribute("toBePaidOrder",result);
                request.getRequestDispatcher("payment.jsp").forward(request,response);

            }
            else {
                System.out.println("后台传入数据有误");
            }
        }
        else {
            System.out.println("前台传入数据有误");
        }

    }

    protected void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("this is update method");
        String orderId=request.getParameter("orderId");
        String status=request.getParameter("status");
        System.out.println("this is update: " + orderId);
        System.out.println("this is update: " + status);
        boolean result=orderDAO.updateOrder(Integer.parseInt(orderId),status);
        if(result){
            response.getWriter().println(1);
            response.getWriter().close();

        }
        else {
            response.getWriter().println(0);
            response.getWriter().close();
            System.out.println("update is faild ");
        }

    }

    protected void listOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("listOrderDetails");
        String orderId=request.getParameter("orderId");
        System.out.println(orderId + "orderid");
        List<OrderDetail> details=detailDAO.listAllOrderDetails(Integer.parseInt(orderId));
        request.setAttribute("orderDetails",details);
        request.getRequestDispatcher("showOrderDetails.jsp").forward(request,response);
    }

    protected void listOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String userId=request.getParameter("userId");
        String page=request.getParameter("page");
        String count=request.getParameter("count");

        PageBean p=new PageBean();
        p.setAllCount(orderDAO.getAllCountOrder(Integer.parseInt(userId)));
        int allPages=p.getAllCount()%Integer.parseInt(count)==0?p.getAllCount()/Integer.parseInt(count):p.getAllCount()/Integer.parseInt(count)+1;
        p.setAllPages(allPages);
        p.setFirstPage(1);
        p.setNowPage(Integer.parseInt(page));
        p.setNextPage(p.getNowPage()==p.getAllPages()?p.getAllPages():p.getNowPage()+1);
        p.setPreviousPage(Integer.parseInt(page)>1?Integer.parseInt(page)-1:1);
        p.setEveryPageCount(Integer.parseInt(count));

        request.setAttribute("pageBean",p);
        List<Order> orders=orderDAO.listAllOrders(Integer.parseInt(userId),Integer.parseInt(page),Integer.parseInt(count));

        Map<Order,List<OrderDetail>> allOrders=new HashMap<>();
        for (Order o: orders){
            List<OrderDetail> details=detailDAO.listAllOrderDetails(o.getOrderId());
            allOrders.put(o,details);
        }
        request.setAttribute("allOrders",allOrders);
        request.getRequestDispatcher("showOrders.jsp").forward(request,response);
    }

    protected void payOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String orderId=request.getParameter("orderId");
        Order order=orderDAO.listOrder(Integer.parseInt(orderId));
        if(order!=null){
            request.setAttribute("toBePaidOrder",order);
            request.getRequestDispatcher("payment.jsp").forward(request,response);
        }else {
            System.out.println("后台传入数据有误");
        }

    }
}
