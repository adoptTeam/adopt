package com.cdg.db.enhance.model;

public class ReplyEntity {
    private Long replyId;
    private Long commentId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    private String replyContent;
    private Long replyTime;
    private Long replyUpTime;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Long replyTime) {
        this.replyTime = replyTime;
    }

    public Long getReplyUpTime() {
        return replyUpTime;
    }

    public void setReplyUpTime(Long replyUpTime) {
        this.replyUpTime = replyUpTime;
    }
}
