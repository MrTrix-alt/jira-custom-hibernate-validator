package ru.custom.atlassian.hibernate.validator.config.validation.constraints.validator;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.atlassian.jira.security.JiraAuthenticationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import ru.custom.atlassian.hibernate.validator.config.service.DummyService;
import ru.custom.atlassian.hibernate.validator.config.validation.constraints.DummySumParamConstraint;

@Slf4j
public class DummySumParamConstraintValidator implements ConstraintValidator<DummySumParamConstraint, Integer> {
    private final DummyService dummyService;
    private final Integer dummyMultiplicationValue;

    private final JiraAuthenticationContext jiraAuthenticationContext;

    public DummySumParamConstraintValidator(
            final DummyService dummyService,
            @Value("${demo.validation.constraint.dummyMultiplicationValue}") final Integer dummyMultiplicationValue,
            final JiraAuthenticationContext jiraAuthenticationContext) {
        this.dummyService = Objects.requireNonNull(dummyService, "dummyService");
        this.dummyMultiplicationValue = Objects.requireNonNull(dummyMultiplicationValue, "dummyMultiplicationValue");
        this.jiraAuthenticationContext = Objects.requireNonNull(jiraAuthenticationContext, "jiraAuthenticationContext");
    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext context) {
        dummyService.doDummyThing();
        log.debug("current user {}", jiraAuthenticationContext.getLoggedInUser());

        if (value * value > dummyMultiplicationValue) {
            log.error("product of annotated by DummySumParamConstraint parameter is not valid {}", value);
            return false;
        }

        log.error("product of annotated by DummySumParamConstraint parameter is valid {}", value);
        return true;
    }
}
