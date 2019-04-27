package edu.hbuas.cake.control;

import edu.hbuas.cake.model.dao.CommentDAO;
import edu.hbuas.cake.model.dao.CommentDAOImp;
import edu.hbuas.cake.model.dao.CommentReplyDAO;
import edu.hbuas.cake.model.dao.CommentReplyDAOImp;
import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.Comment;
import edu.hbuas.cake.model.javabean.CommentReply;
import edu.hbuas.cake.model.javabean.PageBean;
import edu.hbuas.cake.service.CommentService;
import edu.hbuas.cake.service.CommentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommentServlet",urlPatterns = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    private CommentDAO commentDAO;
    private CommentReplyDAO commentReplyDAO;
    private CommentService commentService;

    @Override
    public void init() throws ServletException {
        commentDAO = new CommentDAOImp();
        commentReplyDAO = new CommentReplyDAOImp();
        commentService = new CommentServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        System.out.println("method:" + method);
        switch (method) {
            case "orderComment":{
                orderComment(request, response);
                break;
            }
            case "listCommentByPage":{
                listCommentByPage(request, response);
                break;
            }
            case "listCommentReply":{
                listCommentReply(request, response);
                break;
            }
            case "submitCommentReply":{
                submitCommentReply(request, response);
                break;
            }
            case "submitCommentReplyByAjax":{
                submitCommentReplyByAjax(request, response);
                break;
            }
            case "addLikeByCommentId":{
                addLikeByCommentId(request, response);
                break;
            }
        }
    }


    /**
     * 订单完成后的商品评论方法
     * @param request
     * @param response
     */
    private void orderComment(HttpServletRequest request, HttpServletResponse response) {
        //CommentServlet将处理商品评论的具体功能交给service层处理
        Comment comment = commentService.processOrderComment(request, response);
        boolean result = commentDAO.addComment(comment);
        if (result){
            System.out.println("数据库添加评论成功");
            //评论成功后JSP页面弹框提示，确认之后返回订单页面
        }else{
            System.out.println("数据库添加评论失败");
            //评论失败后。。。
        }
    }

    /**
     * 分页显示蛋糕的评论
     * @param request
     * @param response
     */
    private void listCommentByPage(HttpServletRequest request, HttpServletResponse response) {
        String cakeId = request.getParameter("cakeId");
        String page = request.getParameter("page");
        String count = request.getParameter("count");

        System.out.println("cakeId:" + cakeId + ", " + "page:" + page + ", " + "count:" + count);

        PageBean p = commentService.processListCommentByPage(Integer.parseInt(cakeId), Integer.parseInt(page), Integer.parseInt(count));
        request.setAttribute("pageBean",p);

        try {
            List<Comment> c = commentDAO.listCommentByPage(Integer.parseInt(cakeId),Integer.parseInt(page),Integer.parseInt(count));

            request.setAttribute("allComments",c);
            request.getRequestDispatcher("single.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示评论回复的方法
     * @param request
     * @param response
     */
    private void listCommentReply(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String cakeId = request.getParameter("cakeId");
        String commentId = request.getParameter("commentId");

        System.out.println("userId:" + userId + ", cakeId:" + cakeId + ", commentId:" + commentId);

        try{
            Comment com = commentService.processListCommentById(Integer.parseInt(commentId));
            List<CommentReply> commentReply =  commentService.processCommentReply(Integer.parseInt(userId), Integer.parseInt(cakeId), Integer.parseInt(commentId));

            request.setAttribute("comment", com);
            request.setAttribute("allCommentReply", commentReply);

            System.out.println(com);

            request.getRequestDispatcher("commentDetails.jsp").forward(request, response);
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    /**
     * 提交评论回复的方法
     * @param request
     * @param response
     */
    private void submitCommentReply(HttpServletRequest request, HttpServletResponse response) {

        CommentReply commentReply = commentService.processSubmitCommentReply(request, response);
        boolean result = commentReplyDAO.addCommentReply(commentReply);

        try {
            if (result){
                System.out.println("数据库添加回复评论成功");
                response.getWriter().print(commentReply);
                response.getWriter().close();
                //评论成功后JSP页面弹框提示，确认之后返回订单页面
            }else{
                System.out.println("数据库添加回复评论失败");
                //评论失败后。。。
            }
        }catch (IOException e){
            e.getStackTrace();
        }

    }

    /**
     * Ajax提交评论回复的方法
     * @param request
     * @param response
     */
    private void submitCommentReplyByAjax(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 通过CommentId进行Ajax点赞方法
     * @param request
     * @param response
     */
    private void addLikeByCommentId(HttpServletRequest request, HttpServletResponse response) {

        try{
            boolean result = commentService.processAddLikeByCommentId(request, response);

            response.getWriter().print(result);
            response.getWriter().close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

}
