package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Офис" )
public class OfficeView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @Size(max = 100)
    @NotEmpty(message = "firstName cannot be null")
    @ApiModelProperty(value = "Название", example = "Иван")
    public String name;

    @Size(max = 100)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Москва, ул. Рабочая, 35")
    public String address;

    @Size(max = 45)
    @ApiModelProperty(value = "Телефон", example = "(495)212-0100")
    public String phone;

    @ApiModelProperty(value = "Активен",example="true")
    public Boolean isActive;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public OfficeView(Long id, @Size(max = 100) @NotEmpty(message = "firstName cannot be null") String name, @Size(max = 100) @NotEmpty(message = "address cannot be null") String address, @Size(max = 45) String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeView(@Size(max = 100) @NotEmpty(message = "firstName cannot be null") String name, @Size(max = 100) @NotEmpty(message = "address cannot be null") String address, @Size(max = 45) String phone, Boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeView() {
    }
}
