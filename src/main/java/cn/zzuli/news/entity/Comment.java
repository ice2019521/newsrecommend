package cn.zzuli.news.entity;

public class Comment {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户id
     */
    private Integer userId;

    /**
     * 新闻id
     */
    private Integer newsId;

    /**
     * 评论状态(0为不可见，1为可见)
     */
    private Integer status;

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", newsId=" + newsId +
                ", status=" + status +
                '}';
    }

}