package edu.hbuas.cake.model.javabean;

//这是商品评论类
public class Comment {
    private long commentId;
    private String nickname;
    private String content;
    private float score;
    private long userId;
    private long cakeId;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCakeId() {
        return cakeId;
    }

    public void setCakeId(long cakeId) {
        this.cakeId = cakeId;
    }
}
