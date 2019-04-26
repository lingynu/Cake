package edu.hbuas.cake.service;

import edu.hbuas.cake.model.javabean.Comment;
import edu.hbuas.cake.model.javabean.CommentReply;
import edu.hbuas.cake.model.javabean.PageBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CommentService {
    //处理订单完成后的评论
    public Comment processOrderComment(HttpServletRequest request, HttpServletResponse response);
    //处理商品评论分页
    public PageBean processListCommentByPage(int cakeId, int page, int count);
    //处理评论回复
    public List<CommentReply> processCommentReply(int uuserId, int cakeId, int commentId);
    //处理commentId查找评论
    public Comment processListCommentById(int commentId);
    //处理提交评论回复
    public CommentReply processsSbmitCommentReply(HttpServletRequest request, HttpServletResponse response);
}
