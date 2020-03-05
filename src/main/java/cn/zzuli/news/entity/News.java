package cn.zzuli.news.entity;

import java.util.Date;

public class News {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签id
     */
    private Integer cateId;
    /**
     * 来源id
     */
    private Integer sourceId;

    /**
     * 浏览次数（默认为0）
     */
    private Integer readNum;

    /**
     * 发表时间
     */
    private Date time;

    /**
     * 新闻内容
     */
    private String content;

    public News() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cateId=" + cateId +
                ", sourceId=" + sourceId +
                ", readNum=" + readNum +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}