package food.control;

import food.model.dao.UserDAO;
import food.model.dao.UserDAOImp;
import food.model.javabean.User;


import food.service.UserService;
import food.service.UserServiceImp;
import food.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.UUID;

import static java.lang.System.out;
import static java.lang.System.setOut;

@MultipartConfig
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    private UserService service;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImp();
        service=new UserServiceImp();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //为了让一个servlet能应对前端的多个业务方法请求，我们不得不对serlvet做方法复用.
        //前端我们通过每次请求过来的时候传入一个名字为method参数，通过判断参数的值来知道用户点击了哪个请求，然后调用对应的自定义的方法

        String method = request.getParameter("method");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        switch (method){
            case "login":{
                login(request,response);
                break;
            }
            case "logoff":{
                logoff(request,response);
                break;
            }
            case "checkUserExist":{
                checkUserExist(request,response);
                break;
            }
            case "checkCode":{
                checkCode(request,response);
                break;
            }
            case "register":{
                register(request,response);
                break;
            }
            case "revise":{
                revise(request,response);
                break;
            }

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入检查验证码功能了！");
        String yourinput=request.getParameter("code");

        String systemCode=request.getSession().getAttribute("code").toString();

        System.out.println(yourinput+"---"+systemCode);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        out.write(yourinput.equalsIgnoreCase(systemCode)+"");

        out.flush();
        out.close();

    }
    protected void checkUserExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求到后台了");
        String nickname=request.getParameter("nickname");
        System.out.println("传过来到用户名"+nickname);
        boolean result=userDAO.checkUserExists(nickname);
        System.out.println(result);



        response.setContentType("text/html;charset=utf-8");
        PrintWriter  out=response.getWriter();

        out.write(result+"");
        out.flush();
        out.close();
    }

    /**
     * 这是用户注册的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out.println("进入到注册方法了");
        Part part=request.getPart("head");
        System.out.println(part.getContentType());//文件类型

        String  uuidName= UUID.randomUUID().toString();
        StringBuffer  childpath=new StringBuffer();
        for(int n=0;n<uuidName.length();n++)
        {
            childpath.append( uuidName.charAt(n)+"/");
        }
        String rootpath= request.getRealPath("upload")+"/"+childpath;
        out.println(rootpath);
        File path=new File(rootpath);
        path.mkdirs();
        String newFileName=uuidName+"."+part.getContentType().substring(part.getContentType().indexOf("/")+1,part.getContentType().length());

        String fullPath=newFileName;
        FileOutputStream out=new FileOutputStream(rootpath+newFileName);

        InputStream in=part.getInputStream();
        byte[] bs=new byte[1024];
        int len=-1;
        while((len=in.read(bs))!=-1){

            out.write(bs,0,len);
        }
        out.flush();
        out.close();
        in.close();



        String name= request.getParameter("name");
        String nickname= request.getParameter("nickname");
        String password= request.getParameter("password");
        String head=request.getParameter("head");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        System.out.println(name+"\t"+nickname+"\t"+password+"\t"+head+"\t"+sex+"\t"+age+"\t"+phone);
        //2.链接数据库，将用户填写的资料插入到用户信息表，生成一条新的用户u 记录信息

        User  u=new User();
        u.setName(name);
        //对密码做加盐操作（加盐对业务规则）

        u.setPassword(MD5.genertedPassword(MD5.addSoltToPassword(nickname,password)));

        u.setNickname(nickname);
        u.setHead("upload/"+childpath+newFileName);
        u.setSex(sex);
        u.setAge(Integer.parseInt(age));
        u.setPhone(phone);
        try {
            boolean result=userDAO.register(u);

            //3.判断插入语句的执行结果，跳转到页面提示响应的信息
            if(result){
                response.sendRedirect(response.encodeURL("index.jsp"));
            }else{
                request.setAttribute("errorMessage", "注册失败！");
                request.getRequestDispatcher(response.encodeURL("register.jsp")).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
        }
    }
    /**
     * 自定义的处理退出登陆的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logoff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();//销毁session中所有的数据
        //清除cookie
        Cookie[] cs=request.getCookies();
        for(Cookie c: cs){
            if(c.getName().equals("nickname")){
                c.setValue(null);
                c.setMaxAge(0);
                response.addCookie(c);
                break;
            }
        }
        System.out.println("退出了");
        response.sendRedirect("index.jsp");
    }

    /*处理修改业务的方法*/
    protected void revise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        out.println("进入到修改方法了");
        Part part=request.getPart("head");
        System.out.println(part.getContentType());//文件类型

        String  uuidName= UUID.randomUUID().toString();
        StringBuffer  childpath=new StringBuffer();
        for(int n=0;n<uuidName.length();n++)
        {
            childpath.append( uuidName.charAt(n)+"/");
        }
        String rootpath= request.getRealPath("upload")+"/"+childpath;
        out.println(rootpath);
        File path=new File(rootpath);
        path.mkdirs();
        String newFileName=uuidName+"."+part.getContentType().substring(part.getContentType().indexOf("/")+1,part.getContentType().length());

        String fullPath=newFileName;
        FileOutputStream out=new FileOutputStream(rootpath+newFileName);

        InputStream in=part.getInputStream();
        byte[] bs=new byte[1024];
        int len=-1;
        while((len=in.read(bs))!=-1){

            out.write(bs,0,len);
        }
        out.flush();
        out.close();
        in.close();



        String name= request.getParameter("name");
        String nickname= request.getParameter("nickname");
        String head=request.getParameter("head");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        User user1= (User) request.getSession().getAttribute("user");
        int userId = user1.getUserId();

        System.out.println(password);
        System.out.println(userId);

        System.out.println(name+"\t"+nickname+"\t"+head+"\t"+sex+"\t"+age+"\t"+phone+"\t"+password);
        //2.链接数据库，将用户填写的资料插入到用户信息表，生成一条新的用户u 记录信息

        User  u=new User();
        u.setName(name);
        u.setPassword(password);
        u.setUserId(userId);
        u.setNickname(nickname);
        u.setHead("upload/"+childpath+newFileName);
        u.setSex(sex);
        u.setAge(Integer.parseInt(age));
        u.setPhone(phone);

        try {
            boolean result=userDAO.reviseUserMessage(u);
            System.out.println(result);
            //3.判断插入语句的执行结果，跳转到页面提示响应的信息
            if(result){
                response.sendRedirect(response.encodeURL("login.jsp"));
                request.getSession().invalidate();//销毁session中所有的数据
            }else{
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                request.setAttribute("errorMessage", "修改失败！");
                request.getRequestDispatcher(response.encodeURL("profile.jsp")).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
        }
    }

    /* 处理登陆业务的方法*/
   protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //当前这个login方法对应的前端请求分两种
       //一种是用户正常登陆，需要填写用户名和密码以及验证码

       if(request.getParameter("nickname")!=null&&request.getParameter("password")!=null&&request.getParameter("inputCode")!=null){

           User u=service.processNormalLogin(request,response);

           if(u!=null){
               service.rememberUserToCookie(request,response);
               request.getSession().setAttribute("user",u);
               request.getRequestDispatcher("index.jsp").forward(request,response);
           }else{
               request.setCharacterEncoding("utf-8");
               response.setCharacterEncoding("utf-8");
               out.println("用户名或者密码错误！");
               request.setAttribute("errorMessage", "用户名或者密码错误！");
               request.getRequestDispatcher("login.jsp").forward(request,response);
           }
       }else{
           //第二种自动登陆（三天免登陆），此时用户没有填写任何用户名和密码以及验证码
           User u= service.processCookieLogin(request, response);
           request.getSession().setAttribute("user",u);
           request.getRequestDispatcher("index.jsp").forward(request,response);
       }
   }





}
