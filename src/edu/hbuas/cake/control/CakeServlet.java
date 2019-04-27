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
        System.out.println(method);
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
            case "listTypeCakes":{
                listTypeCakes(request,response);
            }
            case "listSalesCake":{
                listSalesCake(request,response);
            }
            case "listMoHuZhiCake":{
                listMoHuZhiCake(request,response);
            }
            case "listPriceCake":{
                listPriceCake(request,response);
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
            listTypeCakes(request,response);
            listAllCountOfSales(request,response);
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
    protected void listTypeCakes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到了");
        try{
//            List<Cake> c=cakeDAO.listTypeCake(size,flavor);
//            request.setAttribute("allCake",c);
            List<CakeType> cf=cakeTypeDAO.getAllCountOfFlavor();
            request.getSession().setAttribute("allFlavor",cf);
            List<CakeType> cs=cakeTypeDAO.getAllCountOfSize();
            request.getSession().setAttribute("allSize",cs);
//            request.getRequestDispatcher("products.jsp").forward(request,response);
//            System.out.println(c+"111");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void listTypeCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("aaaaaaaa");
        String size=request.getParameter("size");
        String flavor=request.getParameter("flavor");
        System.out.println(flavor);
        System.out.println(size);
        try{
            List<Cake> cs=cakeDAO.listTypeCake(flavor,size);
            request.setAttribute("allCake",cs);
            request.getRequestDispatcher("products.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void listAllCountOfSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到了");
        try{
            List<Cake> ck=cakeDAO.listAllCountOfSales();
            request.getSession().setAttribute("allSales",ck);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void listSalesCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sales=request.getParameter("sales");
        try{
            List<Cake> cs=cakeDAO.listSalesCake(sales);
            request.setAttribute("allCake",cs);
            request.getRequestDispatcher("products.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void listMoHuZhiCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mohuzhi=request.getParameter("mohuzhi");
        try{
            List<Cake> cs=cakeDAO.listMoHuSearch(mohuzhi);
            request.setAttribute("allCake",cs);
            request.getRequestDispatcher("products.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void listPriceCake(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        double minPrice=Double.parseDouble(request.getParameter("minPrice"));
//        double maxPrice=Double.parseDouble(request.getParameter("maxPrice"));
        String amount=request.getParameter("amount");
        String a=amount.substring(0, amount.indexOf("-"));
        String b=amount.substring(amount.indexOf("-")+1);
        double minPrice=Double.parseDouble(a);
        double maxPrice=Double.parseDouble(b);
        try{
           List<Cake> cs=cakeDAO.listPriceCake(minPrice,maxPrice);
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
