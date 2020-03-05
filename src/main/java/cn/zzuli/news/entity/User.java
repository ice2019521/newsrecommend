package cn.zzuli.news.entity;

public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 状态（0为冻结，1为普通用户，2为管理员）
     */
    private Integer status;
    /**
     * 头像地址
     */
    private String head;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", status=" + status +
                ", head='" + head + '\'' +
                '}';
    }

}