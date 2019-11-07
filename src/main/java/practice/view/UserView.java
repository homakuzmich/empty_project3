package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description ="Человек" )
public class UserView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

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

    @ApiModelProperty(value = "Идентифицирован", example = "true")
    public Boolean isIdentified;

    @ApiModelProperty(value="Уникальный идентификатор офиса",example = "1")
    public String officeId;

    public UserView() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }

    public UserView(Long id, @Size(max = 45) @NotEmpty(message = "firstName cannot be null") String firstName, @Size(max = 45) String lastName, @Size(max = 45) String middleName, @Size(max = 45) @NotEmpty(message = "position cannot be null") String position, @Size(max = 45) String phone, Boolean isIdentified, String officeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.officeId = officeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsIdentified(Boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

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


