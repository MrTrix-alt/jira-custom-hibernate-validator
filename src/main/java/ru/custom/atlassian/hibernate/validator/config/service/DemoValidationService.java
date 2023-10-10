package ru.custom.atlassian.hibernate.validator.config.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import ru.custom.atlassian.hibernate.validator.config.validation.constraints.DummySumParamConstraint;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@Slf4j
public class DemoValidationService {

    public void testMethodParamValidation(@Valid @Positive @DummySumParamConstraint int validatedParam) {
      log.debug("executed method testMethodParamValidation with only positive param {} ", validatedParam);
    }
}
