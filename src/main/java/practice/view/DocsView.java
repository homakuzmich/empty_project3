package practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Документы")
public class DocsView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long code;

    @Size(max=45)
    @ApiModelProperty(value = "Название документа", example = "Паспорт")
    public String name;

    @ApiModelProperty(value = "Дата", example = "2016-08-17")
    public Date date;


    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DocsView(@Size(max = 45) String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public DocsView(Long code, @Size(max = 45) String name, Date date) {
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public DocsView(Long code, @Size(max = 45) String name) {
        this.code = code;
        this.name = name;
    }

    public DocsView() {
    }

    @Override
    public String toString() {
        return "DocsView{" +
                "id='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
