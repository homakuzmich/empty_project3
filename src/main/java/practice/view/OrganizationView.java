package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Организация" )
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

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
