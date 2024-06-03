package ru.custom.atlassian.hibernate.validator.config.validation.constraints;

import ru.custom.atlassian.hibernate.validator.config.validation.constraints.validator.DummySumParamConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {DummySumParamConstraintValidator.class})
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DummySumParamConstraint {
    String message() default "dummy.sum.param.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
