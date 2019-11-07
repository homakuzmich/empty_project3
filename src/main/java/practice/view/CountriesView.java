package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страны")
public class CountriesView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long code;

    @Size(max=45)
    @ApiModelProperty(value = "Название страны", example = "Нидерланды")
    @NotEmpty
    public String name;

    public CountriesView(Long code, @Size(max = 45) String name) {
        this.code = code;
        this.name = name;
    }

    public CountriesView(@Size(max = 45) String name) {
    }

    public CountriesView() {
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountriesView{" +
                "id='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
