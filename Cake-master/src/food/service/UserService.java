package food.service;

import food.model.javabean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public User processNormalLogin(HttpServletRequest request, HttpServletResponse response);
    public User processCookieLogin(HttpServletRequest request, HttpServletResponse response);
    public void rememberUserToCookie(HttpServletRequest request, HttpServletResponse response);
}
