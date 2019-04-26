package edu.hbuas.cake.control;

import edu.hbuas.cake.model.dao.UserDAO;
import edu.hbuas.cake.model.dao.UserDAOImp;
import edu.hbuas.cake.model.javabean.User;
import sun.util.resources.cldr.gl.LocaleNames_gl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//这是用户登录、退出登录或注册时调用的Servlet
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImp();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "login":{
                login(request,response);
                break;
            }
            case "register":{
                register(request,response);
                break;
            }
            case "logout":{
                logout(request,response);
                break;
            }
        }

    }

//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charSet=UTF-8");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        System.out.println(email + password);
//    }
    //用户登陆的方法，判断是否记住密码，cookie里是否有用户信息
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("nininiini");
        int userId = Integer.parseInt(request.getParameter("userId"));
        String password = request.getParameter("password");
        System.out.println("登陆的方法：\t"+userId+"\t\t"+password);
        try{
            User u = userDAO.login(userId,password);
            PrintWriter out=response.getWriter();

            if(u!=null){
                System.out.println(u.getNickname() + "nick");
                System.out.println(u.getName() + "name");
                System.out.println(u.getUserId() + "id");
                System.out.println(u.getAge() + "age");
                request.getSession().setAttribute("user",u);

                out.write(u.getNickname());

//                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                System.out.println("你错了");
                out.write("faid");
            }
            out.flush();
            out.close();

        } catch (Exception e){

        }
    }

    //用户注册的方法，注册成功跳转到登录
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //用户退出的方法，退出即销毁cookie里保存的用户信息
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
