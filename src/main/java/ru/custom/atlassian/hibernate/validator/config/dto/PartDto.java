package ru.custom.atlassian.hibernate.validator.config.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class PartDto {

    /**
     * example: username@domain.com
     */
    @NotBlank
    @Email(regexp = "^(.+)@(\\S+)$")
    private String someStringPropAsEmail;
}
