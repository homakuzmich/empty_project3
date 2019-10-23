package practice.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name="Countries")
public class Countries {

    @Id
    @GeneratedValue
    @Column(name="code")
    private Long code;

    @Version
    private Integer version;

    @Column(name="name",length = 45)
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="code")
    private User user;

    public Countries(@Size(max = 45) String name) {
    }

    public Countries(String name, String userId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Countries() {
    }

    @Override
    public String toString() {
        return "Countries{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
