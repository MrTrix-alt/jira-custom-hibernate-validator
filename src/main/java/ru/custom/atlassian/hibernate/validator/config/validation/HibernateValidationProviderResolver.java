package ru.custom.atlassian.hibernate.validator.config.validation;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ValidationProviderResolver;
import javax.validation.spi.ValidationProvider;
import java.util.Collections;
import java.util.List;

public class HibernateValidationProviderResolver implements ValidationProviderResolver {

    @Override
    public List<ValidationProvider<?>> getValidationProviders() {
        return Collections.singletonList(new HibernateValidator());
    }
}