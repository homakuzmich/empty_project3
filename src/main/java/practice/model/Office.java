package practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Version
    private Integer version;

    @Column(name="name",length = 100,nullable = false)
    private String name;

    @Column(name="address",length = 100,nullable = false)
    private String address;

    @Column(name="phone",length=45)
    private String phone;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="User_id")
    private Long userId;

    @OneToMany(mappedBy="office",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<User> users=new HashSet<User>();

    @ManyToMany(mappedBy = "offices")
    private Set<Organization> organizations=new HashSet<>();

    public Set<Organization> getOrganizations() {
        if (organizations == null) {
            organizations = new HashSet<>();
        }
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                ", userId=" + userId +
                ", users=" + users +
                ", organizations=" + organizations +
                '}';
    }

    public Office() {
    }

    public Office(String name, String address, String phone, Boolean isActive, Long userId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.userId = userId;
    }

    public Set<User> getUsers() {
        if (users == null) {
            users = new HashSet<>();
        }
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.getUsers().add(user);
    }


}
