package ru.custom.atlassian.hibernate.validator.config.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import ru.custom.atlassian.hibernate.validator.config.validation.HibernateValidationProviderResolver;

@Configuration
public class ValidationApiConfiguration {

    @Bean
    LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationProviderResolver(new HibernateValidationProviderResolver());
        return localValidatorFactoryBean;
    }

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor(final LocalValidatorFactoryBean localValidatorFactoryBean) {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidator(localValidatorFactoryBean);
        return methodValidationPostProcessor;
    }

}