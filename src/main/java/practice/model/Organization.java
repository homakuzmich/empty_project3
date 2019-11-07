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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "Organization_Office",
            joinColumns = @JoinColumn(name = "Organization_id"),
            inverseJoinColumns = @JoinColumn(name = "Office_id"))
    private Set<Office> offices=new HashSet<>();

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
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

    public Organization() {
    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.getOrganizations().add(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.getOrganizations().remove(this);
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
                ", offices=" + offices +
                '}';
    }
}