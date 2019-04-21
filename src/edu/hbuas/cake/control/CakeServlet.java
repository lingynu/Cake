package edu.hbuas.cake.control;

import edu.hbuas.cake.model.dao.CakeDAO;
import edu.hbuas.cake.model.dao.CakeDAOImp;
import edu.hbuas.cake.model.dao.CakeTypeDAO;
import edu.hbuas.cake.model.dao.CakeTypeDAOImp;
import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.CakeType;
import edu.hbuas.cake.model.javabean.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CakeServlet",urlPatterns = "/CakeServlet")
public class CakeServlet extends HttpServlet {
    private CakeDAO cakeDAO;
    private CakeTypeDAO cakeTypeDAO;
    public void init() throws ServletException{
        cakeDAO=new CakeDAOImp();
        cakeTypeDAO=new CakeTypeDAOImp();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String method=request.getParameter("method");
        switch (method){
            case "listAllCake":{
                listAllCake(request,response);
                break;
            }
            case "listCake":{
                listCake(request,response);
                break;
            }
            case "listTypeCake":{
                listTypeCake(request,response);
            }

        }
    }
    protected void listAllCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page=request.getParameter("page");
        String count=request.getParameter("count");
        PageBean p=new PageBean();
        p.setAllCount(cakeDAO.getAllCountOfCake());
        int allPage=p.getAllCount()%Integer.parseInt(count)==0?p.getAllCount()/Integer.parseInt(count):p.getAllCount()/Integer.parseInt(count)+1;
        p.setAllPage(allPage);
        p.setFirstPage(1);
        p.setNowPage(Integer.parseInt(page));
        p.setNextPage(p.getNowPage()==p.getAllCount()?p.getAllPage():p.getNowPage()+1);
        p.setPreviousPage(Integer.parseInt(page)>1?Integer.parseInt(page)-1:1);
        p.setEveryPageCount(Integer.parseInt(count));
        request.setAttribute("pageBean",p);
        try{
            List<Cake> cs=cakeDAO.listAllCake(Integer.parseInt(page),Integer.parseInt(count));
            request.setAttribute("allCake",cs);
            request.getRequestDispatcher("products.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    protected void listCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cakeId=request.getParameter("cakeId");
        try {
            Cake c=cakeDAO.listCake(Integer.parseInt(cakeId));
            request.setAttribute("cake",c);
            request.getRequestDispatcher("single.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void listTypeCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String size=request.getParameter("size");
        String flavor=request.getParameter("flavor");
        try{
            List<Cake> cs=cakeDAO.listTypeCake(size,flavor);
            request.setAttribute("allCake",cs);
            request.getRequestDispatcher("products.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
