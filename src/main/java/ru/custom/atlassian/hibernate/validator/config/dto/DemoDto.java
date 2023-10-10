package ru.custom.atlassian.hibernate.validator.config.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@XmlRootElement
public class DemoDto {

    @NotNull(message = "someNumberProp cannot be null")
    @Min(value = 40, message = "someNumberProp cannot be less than 40")
    @XmlElement
    private Integer someNumberProp;

    @Valid
    @XmlElement
    private PartDto partDto;
}
