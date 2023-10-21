package ru.custom.atlassian.hibernate.validator.config.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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
public class PartDto {

    /**
     * example: username@domain.com
     */
    @NotNull(message = "someStringPropAsEmail cannot be null")
    @Email(message = "someStringPropAsEmail must match email as 'username@domain.com'", regexp = "^(.+)@(\\S+)$")
    private String someStringPropAsEmail;
}
