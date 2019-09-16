package practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Version
    private Integer version;

    @Column(name="name",length=45,nullable = false)
    private String name;

    @Column(name="full_name",length = 100,nullable = false)
    private String fullName;

    @Column(name="inn",length = 45,nullable = false)
    private String inn;

    @Column(name="kpp",length = 45,nullable = false)
    private String kpp;

    @Column(name="address",length = 200,nullable = false)
    private String address;

    @Column(name="phone",length=45)
    private String phone;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="Office_id",nullable = false)
    private Long officeId;

    @OneToMany(mappedBy = "Organization",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Office> organizations=new HashSet<Office>();

    public Set<Office> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Office> organizations) {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                ", officeId=" + officeId +
                '}';
    }
}