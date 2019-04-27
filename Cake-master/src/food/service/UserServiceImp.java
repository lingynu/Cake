package food.service;

import food.model.dao.UserDAO;
import food.model.dao.UserDAOImp;
import food.model.javabean.User;
import food.util.MD5;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserServiceImp implements  UserService {
    private UserDAO dao;
    public UserServiceImp(){
        dao=new UserDAOImp();
    }




    public User processNormalLogin(HttpServletRequest request, HttpServletResponse response) {
        //1.先获取上一个页面用户输入的账号信息
        String inputCode= request.getParameter("inputCode");
        User u=null;
        if(inputCode.equalsIgnoreCase(request.getSession().getAttribute("code").toString())) {
            String nickname = request.getParameter("nickname");
            String password = request.getParameter("password");
            System.out.println(nickname + "\t" + password);
            System.out.println(request.getContextPath());


            //2.查询数据库中有没有这个账户密码对应的用户信息


            u = dao.login(nickname, MD5.genertedPassword(MD5.addSoltToPassword(nickname, password)));
            System.out.println("查询出来的用use" + u);


        }
            //3.判断查询结果，如果查到该用户则跳转到首页，没有则跳到登陆页面，提示错误消息

            return u;

    }

    @Override
    public User processCookieLogin(HttpServletRequest request, HttpServletResponse response) {
        String nickname=null;
        Cookie[]  cs=request.getCookies();
        for(Cookie c:cs){
            if(c.getName().equals("nickname")){
                nickname=c.getValue();
                break;
            }
        }
        User  u=dao.login(nickname);
        return u;
    }

    @Override
    public void rememberUserToCookie(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("rememberMe")!=null){
            Cookie  c=new Cookie("nickname",request.getParameter("nickname"));
            c.setMaxAge(60*60*24*3);
            response.addCookie(c);
        }
    }
}
