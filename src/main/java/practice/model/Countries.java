package practice.model;

import javax.persistence.*;

@Entity(name="Countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code")
    private Long code;

    @Version
    private Integer version;

    @Column(name="name",length = 45)
    private String name;

    @Column(name="User_id")
    private Integer userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Docs_code",referencedColumnName = "code")
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
        return "Countries{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
