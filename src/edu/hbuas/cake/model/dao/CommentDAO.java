package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Comment;

import java.util.List;

public interface CommentDAO {
    //查询指定蛋糕下的所有评论
    public List<Comment> listAllComment(long cakeId);
    public boolean addComment(Comment comment);
}
