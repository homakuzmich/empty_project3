package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страны")
public class CountriesView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String code;

    @Size(max=45)
    @ApiModelProperty(value = "Название страны", example = "Нидерланды")
    public String name;

    @Override
    public String toString() {
        return "CountriesView{" +
                "id='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
