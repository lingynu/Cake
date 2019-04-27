package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.CommentReply;

import java.sql.PreparedStatement;

public class CommentReplyDAOImp extends BaseDAOImp implements CommentReplyDAO {
    @Override
    public boolean addCommentReply(CommentReply commentReply) {
        String addCommentReplySQL="insert into commentreply(userId,cakeId,commentId,replyUserId,replyNickName,content) values(?,?,?,?,?,?)";
        boolean result = false;

        try {
            PreparedStatement pre = getPre(addCommentReplySQL);
            pre.setInt(1 ,commentReply.getUserId());
            pre.setInt(2 ,commentReply.getCakeId());
            pre.setInt(3 ,commentReply.getCommentId());
            pre.setInt(4 ,commentReply.getReplyUserId());
            pre.setString(5 ,commentReply.getReplyNickName());
            pre.setString(6 ,commentReply.getContent());

            result = pre.executeUpdate()>0?true:false;

            System.out.println("数据库添加一条回复评论");


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
