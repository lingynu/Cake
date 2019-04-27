package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Comment;
import edu.hbuas.cake.model.javabean.CommentReply;

import java.util.List;

public interface CommentDAO {
    //通过cakeId查询指定蛋糕下的所有评论
    public int getAllCommentCount(int cakeId);
    //添加评论
    public boolean addComment(Comment comment);
    //通过cakeId,page,count显示页面的评论
    public List<Comment> listCommentByPage(int cakeId, int page, int count);
    //通过userId,cakeId,commentId显示评论回复
    public List<CommentReply> listCommentReply(int userId, int cakeId, int commentId);
    //通过commentId查找评论信息
    public Comment listCommentById(int commentId);
    //通过commentId进行点赞
    public boolean addLikeByCommentId(int commentId);
}
