package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Документы")
public class DocsView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String code;

    @Size(max=45)
    @ApiModelProperty(value = "Название документа", example = "Паспорт")
    public String name;

    @ApiModelProperty(value = "Дата", example = "2016-08-17")
    public String date;

    @ApiModelProperty(value = "Уникальный идентификатор пользователя", example = "1", hidden = true)
    public String userId;

    @Override
    public String toString() {
        return "DocsView{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
