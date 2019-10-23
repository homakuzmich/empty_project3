package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Человек" )
public class UserView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 45)
    @NotEmpty(message = "firstName cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 45)
    @ApiModelProperty(value = "Фамилия", example = "Андреев")
    public String lastName;

    @Size(max = 45)
    @ApiModelProperty(value = "Отчество", example = "Сергеевич")
    public String middleName;

    @Size(max = 45)
    @NotEmpty(message = "position cannot be null")
    @ApiModelProperty(value = "Должность", example = "Менеджер")
    public String position;

    @Size(max = 45)
    @ApiModelProperty(value = "Телефон", example = "Андреев")
    public String phone;

    @ApiModelProperty(value = "Идентифицирован")
    public Boolean isIdentified;

    @ApiModelProperty(value="Уникальный идентификатор офиса",example = "1")
    public String officeId;

    @Override
    public String toString() {
        return "UserView{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", isIdentified=" + isIdentified +
                ", officeId='" + officeId + '\'' +
                '}';
    }
}


