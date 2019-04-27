package edu.hbuas.cake.model.javabean;

public class CommentReply {
    private int commentReplyId;
    private int userId;
    private int cakeId;
    private int commentId;
    private int replyUserId;
    private String replyNickName;
    private String content;

    public int getCommentReplyId() {
        return commentReplyId;
    }

    public void setCommentReplyId(int commentReplyId) {
        this.commentReplyId = commentReplyId;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyNickName() {
        return replyNickName;
    }

    public void setReplyNickName(String replyNickName) {
        this.replyNickName = replyNickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentReply{" +
                "commentReplyId=" + commentReplyId +
                ", userId=" + userId +
                ", cakeId=" + cakeId +
                ", commentId=" + commentId +
                ", replyUserId=" + replyUserId +
                ", replyNickName='" + replyNickName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
