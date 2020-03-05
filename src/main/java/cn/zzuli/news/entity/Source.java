package cn.zzuli.news.entity;

public class Source {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String content;


    public Source() {
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
        return "Source{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

}