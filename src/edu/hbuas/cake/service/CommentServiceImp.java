package edu.hbuas.cake.service;

import edu.hbuas.cake.model.dao.CommentDAO;
import edu.hbuas.cake.model.dao.CommentDAOImp;
import edu.hbuas.cake.model.dao.CommentReplyDAO;
import edu.hbuas.cake.model.dao.CommentReplyDAOImp;
import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.Comment;
import edu.hbuas.cake.model.javabean.CommentReply;
import edu.hbuas.cake.model.javabean.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommentServiceImp implements CommentService {
    private CommentDAO commentDAO;
    private CommentReplyDAO commentReplyDAO;

    public CommentServiceImp() {
        commentDAO = new CommentDAOImp();
        commentReplyDAO = new CommentReplyDAOImp();
    }

    @Override
    public Comment processOrderComment(HttpServletRequest request, HttpServletResponse response) {
        //判断用户是否是匿名评价
        String nickname;
        if (request.getParameterValues("anonymous") != null){
            String content = request.getParameter("content");
            char[] nname = content.toCharArray();
            nickname = nname[0] + "******" + nname[nname.length-1];
        }else{
            nickname = "小测试";
        }

        String content = request.getParameter("content");
        float score = Float.parseFloat(request.getParameter("score"));
        int userId = 1;
        int cakeId = 1;

        Comment com = new Comment();
        com.setNickname(nickname);
        com.setContent(content);
        com.setScore(score);
        com.setUserId(userId);
        com.setCakeId(cakeId);

        return com;
    }

    @Override
    public PageBean processListCommentByPage(int cakeId, int page, int count) {

        PageBean p = new PageBean();

        p.setAllCount(commentDAO.getAllCommentCount(cakeId));
        int allPages = p.getAllCount()%count==0?p.getAllCount()/count:p.getAllCount()/count+1;
        p.setAllPages(allPages);
        p.setFirstPage(1);
        p.setNowPage(page);
        p.setNextPage(p.getNowPage()==p.getAllPages()?p.getAllPages():p.getNowPage()+1);
        p.setPreviousPage(page>1?page-1:1);
        p.setLastPage(allPages);

        return p;
    }

    @Override
    public List<CommentReply> processCommentReply(int userId, int cakeId, int commentId) {
        List<CommentReply> commentReply = commentDAO.listCommentReply(userId, cakeId, commentId);
        return commentReply;
    }

    @Override
    public Comment processListCommentById(int commentId) {
        Comment comment = commentDAO.listCommentById(commentId);
        return comment;
    }

    @Override
    public CommentReply processSubmitCommentReply(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String cakeId = request.getParameter("cakeId");
        String commentId = request.getParameter("commentId");
        String replyUserId = "2";
        String replyNickName = "2";
        String content = request.getParameter("replyContent");

        CommentReply commentReply = new CommentReply();
        commentReply.setUserId(Integer.parseInt(userId));
        commentReply.setCakeId(Integer.parseInt(cakeId));
        commentReply.setCommentId(Integer.parseInt(commentId));
        commentReply.setReplyUserId(Integer.parseInt(replyUserId));
        commentReply.setReplyNickName(replyNickName);
        commentReply.setContent(content);

        return commentReply;
    }

    @Override
    public boolean processAddLikeByCommentId(HttpServletRequest request, HttpServletResponse response) {
        String commentId=request.getParameter("commentId");

        boolean result = commentDAO.addLikeByCommentId(Integer.parseInt(commentId));
        if (result){
            System.out.println("数据库更新like + 1成功");
        }else {
            System.out.println("数据库更新like + 1失败");
        }
        return result;
    }
}
