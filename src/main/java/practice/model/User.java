package practice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Version
    private Integer version;

    @Column(name="first_name",length=45,nullable = false)
    private String firstName;

    @Column(name="last_name",length = 45)
    private String lastName;

    @Column(name="middle_name",length = 45)
    private String middleName;

    @Column(name="position",length = 45,nullable = false)
    private String position;

    @Column(name="phone",length = 45)
    private String phone;

    @Column(name="is_identified")
    private Boolean isIdentified;

    @Column(name="office_id",insertable = false,updatable = false)
    private Integer officeId;

    @ManyToOne
    @JoinColumn(name="office_id")
    private Office office;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="Docs")
    @PrimaryKeyJoinColumn(name="id")
    @JoinColumn(name="id",insertable = false, updatable = false) /*referencedColumnName = "code"*/
    private Docs docs;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="Countries")
    @PrimaryKeyJoinColumn(name="id")
    @JoinColumn(name="id",insertable = false,updatable = false)/*referencedColumnName = "code"*/
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

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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
                ", officeId=" + officeId +
                ", office=" + office +
                ", docs=" + docs +
                ", countries=" + countries +
                '}';
    }

    public User(@Size(max = 45) @NotEmpty(message = "firstName cannot be null") String firstName, @Size(max = 45) String lastName, @Size(max = 45) String middleName, @Size(max = 45) @NotEmpty(message = "position cannot be null") String position, @Size(max = 45) String phone, Boolean isIdentified) {
    }

    public User() {
    }

    public User(String firstName, String position) {
        this.firstName = firstName;
        this.position = position;
    }
}
