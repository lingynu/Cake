package edu.hbuas.cake.model.dao;

import edu.hbuas.cake.model.javabean.Cake;
import edu.hbuas.cake.model.javabean.CakeType;
import edu.hbuas.cake.model.javabean.Comment;
import edu.hbuas.cake.model.javabean.CommentReply;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImp extends BaseDAOImp implements CommentDAO {
    /**
     * 通过cakeId查询数据库中对应蛋糕的所有评价数量
     * @param cakeId
     * @return
     */
    @Override
    public int getAllCommentCount(int cakeId) {
        int result=0;
        ResultSet rs = null;
        try {
            rs=getSta().executeQuery("select count(id) from comment where comment.cakeId = " + cakeId);
            rs.next();
            result=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("查询到该蛋糕所有的评论条数");

        return result;
    }

    /**
     * 向数据库中添加蛋糕的评价信息
     * @param comment
     * @return
     */
    @Override
    public boolean addComment(Comment comment) {
        String addCommentSQL="insert into comment(nickname,content,score,userId,cakeId) values(?,?,?,?,?)";
        boolean result = false;

        try {
            PreparedStatement pre = getPre(addCommentSQL);
            pre.setString(1 ,comment.getNickname());
            pre.setString(2 ,comment.getContent());
            pre.setFloat(3 ,comment.getScore());
            pre.setInt(4 ,comment.getUserId());
            pre.setInt(5 ,comment.getCakeId());

            result = pre.executeUpdate()>0?true:false;

            System.out.println("数据库添加一条商品评价");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Comment> listCommentByPage(int cakeId, int page, int count) {
        List<Comment> comment = new ArrayList<>();
        try {
            ResultSet rs = getSta().executeQuery("select * from comment, cake, caketype where comment.id = cake.id and cake.typeId = caketype.id limit "+(page-1)*count+","+count);
            while(rs.next()){
                Comment com = new Comment();
                com.setCommentId(rs.getInt("comment.id"));
                com.setNickname(rs.getString("nickname"));
                com.setContent(rs.getString("content"));
                com.setScore(rs.getFloat("score"));
                com.setLike(rs.getInt("like"));
                com.setUserId(rs.getInt("userId"));
                com.setCakeId(rs.getInt("cakeId"));


                comment.add(com);

                Cake ca = new Cake();
                ca.setCakeId(rs.getInt("cake.id"));
                ca.setCakeName(rs.getString("name"));
                ca.setImageUrl(rs.getString("image"));
                ca.setPrice(rs.getDouble("price"));
                ca.setStock(rs.getInt("stock"));
                ca.setSales(rs.getInt("sales"));
                ca.setDescribe(rs.getString("describe"));

                CakeType ct = new CakeType();
                ct.setCakeTypeId(rs.getInt("caketype.id"));
                ct.setSize(rs.getInt("size"));
                ct.setFlavor(rs.getString("flavor"));

                ca.setType(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comment;
    }

    @Override
    public List<CommentReply> listCommentReply(int userId, int cakeId, int commentId) {
        List<CommentReply> commentReply = new ArrayList<>();

        try {
            ResultSet rs = getSta().executeQuery("select * from commentreply where userId = " + userId + " and cakeId = " + cakeId + " and commentId = " + commentId);
            while(rs.next()){
                CommentReply comReply = new CommentReply();
                comReply.setCommentReplyId(rs.getInt("id"));
                comReply.setUserId(rs.getInt("userId"));
                comReply.setCakeId(rs.getInt("cakeId"));
                comReply.setCommentId(rs.getInt("commentId"));
                comReply.setReplyUserId(rs.getInt("replyUserId"));
                comReply.setReplyNickName(rs.getString("replyNickName"));
                comReply.setContent(rs.getString("content"));

                commentReply.add(comReply);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return commentReply;
    }

    @Override
    public Comment listCommentById(int commentId) {
        Comment comment = new Comment();
        try{
            ResultSet rs = getSta().executeQuery("select * from comment where id = " + commentId);

            while (rs.next()) {
                comment.setCommentId(rs.getInt("id"));
                comment.setNickname(rs.getString("nickname"));
                comment.setContent(rs.getString("content"));
                comment.setScore(rs.getFloat("score"));
                comment.setLike(rs.getInt("like"));
                comment.setUserId(rs.getInt("userId"));
                comment.setCakeId(rs.getInt("cakeId"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public boolean addLikeByCommentId(int commentId) {
        boolean result = false;

        try {
            int updateNum = getSta().executeUpdate("update comment set `like` = `like` + 1 where id = " + commentId);

            result = updateNum >= 1?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
