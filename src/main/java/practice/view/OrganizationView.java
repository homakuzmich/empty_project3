package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Организация" )
public class OrganizationView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @NotEmpty(message = "Name cannot be null")
    @Size(max = 45)
    public String name;

    @NotEmpty(message = "fullName cannot be null")
    @Size(max = 100)
    public String fullName;

    @NotEmpty(message = "inn cannot be null")
    @Size(max = 45)
    public String inn;

    @NotEmpty(message = "kpp cannot be null")
    @Size(max = 45)
    public String kpp;

    @NotEmpty(message = "address cannot be null")
    @Size(max = 200)
    public String address;

    @Size(max = 45)
    public String phone;

    @ApiModelProperty(value = "Активен",example="true")
    public Boolean isActive;

    public OrganizationView() {
    }

    public OrganizationView(@NotEmpty(message = "Name cannot be null") @Size(max = 45) String name, @NotEmpty(message = "fullName cannot be null") @Size(max = 100) String fullName, @NotEmpty(message = "inn cannot be null") @Size(max = 45) String inn, @NotEmpty(message = "kpp cannot be null") @Size(max = 45) String kpp, @NotEmpty(message = "address cannot be null") @Size(max = 200) String address, @Size(max = 45) String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OrganizationView(@NotEmpty Long id, @NotEmpty(message = "Name cannot be null") @Size(max = 45) String name, @NotEmpty(message = "fullName cannot be null") @Size(max = 100) String fullName, @NotEmpty(message = "inn cannot be null") @Size(max = 45) String inn, @NotEmpty(message = "kpp cannot be null") @Size(max = 45) String kpp, @NotEmpty(message = "address cannot be null") @Size(max = 200) String address, @Size(max = 45) String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OrganizationView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
