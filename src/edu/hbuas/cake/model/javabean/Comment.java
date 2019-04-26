package edu.hbuas.cake.model.javabean;

//这是商品评论类
public class Comment {
    private int commentId;
    private String nickname;
    private String content;
    private float score;
    private int userId;
    private int cakeId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", userId=" + userId +
                ", cakeId=" + cakeId +
                '}';
    }
}