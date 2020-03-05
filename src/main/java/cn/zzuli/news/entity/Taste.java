package cn.zzuli.news.entity;

public class Taste {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 标签id
     */
    private Integer cateId;

    public Taste() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    @Override
    public String toString() {
        return "Taste{" +
                "id=" + id +
                ", userId=" + userId +
                ", cateId=" + cateId +
                '}';
    }

}