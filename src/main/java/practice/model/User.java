package practice.model;

import javax.persistence.*;

@Entity(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Version
    private Integer version;

    @Column(name="first_name",length=45,nullable = false)
    private String firstName;

    @Column(name="last_name",length = 45)
    private String lastName;

    @Column(name="middle_name",length = 45)
    private String middleName;

    @Column(name="position",length = 45)
    private String position;

    @Column(name="phone",length = 45)
    private String phone;

    @Column(name="is_identified")
    private Boolean isIdentified;

    @ManyToOne
    @JoinColumn(name="office_id",nullable = false)
    private Office office;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Docs_code",referencedColumnName = "code")
    private Docs docs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Countries_code",referencedColumnName = "code")
    private Countries countries;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Docs getDocs() {
        return docs;
    }

    public void setDocs(Docs docs) {
        this.docs = docs;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", isIdentified=" + isIdentified +
                ", office=" + office +
                ", docs=" + docs +
                ", countries=" + countries +
                '}';
    }
}
