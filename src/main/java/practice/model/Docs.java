package practice.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Docs")
public class Docs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code")
    private Long code;

    @Version
    private Integer version;

    @Column(name="name",length = 45)
    private String name;

    @Column(name="date")
    private Date date;

    @Column(name="User_Id")
    private Integer userId;

    @OneToOne(mappedBy = "Docs")
    private User user;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Docs{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
