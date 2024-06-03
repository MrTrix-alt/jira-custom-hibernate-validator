package ru.custom.atlassian.hibernate.validator.config.dto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class DemoDto {

    @NotNull
    @Min(value = 40)
    @XmlElement
    private Integer someNumberProp;

    @Valid
    @XmlElement
    private PartDto partDto;
}
