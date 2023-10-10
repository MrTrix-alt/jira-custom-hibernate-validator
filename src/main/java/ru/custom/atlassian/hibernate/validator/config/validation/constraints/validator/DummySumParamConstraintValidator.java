package ru.custom.atlassian.hibernate.validator.config.validation.constraints.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import ru.custom.atlassian.hibernate.validator.config.service.DummyService;
import ru.custom.atlassian.hibernate.validator.config.validation.constraints.DummySumParamConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class DummySumParamConstraintValidator implements ConstraintValidator<DummySumParamConstraint, Integer> {
    private final DummyService dummyService;

    private final Integer dummyMultiplicationValue;

   public DummySumParamConstraintValidator(DummyService dummyService, @Value("${demo.validation.constraint.dummyMultiplicationValue}") Integer dummyMultiplicationValue) {
        this.dummyService = dummyService;
        this.dummyMultiplicationValue = dummyMultiplicationValue;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        dummyService.doDummyThing();
        if (value * value > dummyMultiplicationValue) {
            log.error("product of annotated by DummySumParamConstraint parameter is not valid {}", value);
            return false;
        }
        log.error("product of annotated by DummySumParamConstraint parameter is valid {}", value);
        return true;
    }
}
