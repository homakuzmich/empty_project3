package practice.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name="Docs")
public class Docs {

    @Id
    @GeneratedValue
    @Column(name="code")
    private Long code;

    @Version
    private Integer version;

    @Column(name="name",length = 45)
    private String name;

    @Column(name="date")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @MapsId
    private User user;

    public Docs(@Size(max = 45) String name, String date) {
    }

    public Docs(String name, String date, String userId) {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Docs() {
    }

    @Override
    public String toString() {
        return "Docs{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
