package food.control.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤器类，将所有网页请求和相应的字符集编码都设置为UTF-8
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("字符集统一utf-8编码");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        request.setCharacterEncoding("utf-8");

        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.setCharacterEncoding("utf-8");

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}