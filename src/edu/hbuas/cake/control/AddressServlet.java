package edu.hbuas.cake.control;



import edu.hbuas.cake.model.dao.AddressDAO;
import edu.hbuas.cake.model.dao.AddressDAOImp;
import edu.hbuas.cake.model.javabean.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddressServlet", urlPatterns = "/AddressServlet")
public class AddressServlet extends HttpServlet {
    private AddressDAO addressDAO;

    @Override
    public void init() throws ServletException {
        addressDAO = new AddressDAOImp();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "show":{
                show(request,response);
                break;
            }
            case "add":{
                add(request,response);
                break;
            }
            case "update":{
                update(request,response);
                break;
            }
            case "delete":{
                delete(request,response);
                break;
            }
        }

    }

    //展示用户所有收货地址
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("userId");
        try {
            List<Address> addresses=addressDAO.listAllAddress(Integer.parseInt(userId));
            request.setAttribute("manyAddress",addresses);
            System.out.println(addresses);
            request.getRequestDispatcher("confirmOrder.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("这是addressServlet里的show方法，我出错了");
        }
    }

    //添加一个收货地址
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //修改用户收货地址
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //删除用户收货地址
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
