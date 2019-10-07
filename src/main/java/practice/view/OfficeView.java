package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Офис" )
public class OfficeView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 100)
    @NotEmpty(message = "firstname cannot be null")
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

    @ApiModelProperty(value = "Id пользователя", example = "1",hidden = true)
    public String userId;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                ", userId='" + userId + '\'' +
                '}';
    }
}
