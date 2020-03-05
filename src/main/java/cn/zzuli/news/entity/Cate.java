package cn.zzuli.news.entity;

public class Cate {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String content;

    public Cate() {
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

    @Override
    public String toString() {
        return "Cate{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

}