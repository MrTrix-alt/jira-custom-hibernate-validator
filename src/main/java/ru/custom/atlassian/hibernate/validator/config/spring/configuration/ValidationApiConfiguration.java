package ru.custom.atlassian.hibernate.validator.config.spring.configuration;

import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.sal.api.message.I18nResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import ru.custom.atlassian.hibernate.validator.config.validation.HibernateValidationProviderResolver;
import ru.custom.atlassian.hibernate.validator.config.validation.JiraPluginCustomValidationMessageInterpolator;

import javax.validation.MessageInterpolator;
import javax.validation.ValidationProviderResolver;

@Configuration
public class ValidationApiConfiguration {

    @Bean
    MessageInterpolator jiraPluginCustomValidationMessageInterpolator(
            final I18nResolver i18nResolver,
            final JiraAuthenticationContext jiraAuthenticationContext) {
        return new JiraPluginCustomValidationMessageInterpolator(i18nResolver, jiraAuthenticationContext);
    }

    @Bean
    ValidationProviderResolver hibernateValidationProviderResolver() {
        return new HibernateValidationProviderResolver();
    }

    @Bean
    LocalValidatorFactoryBean localValidatorFactoryBean(
            final MessageInterpolator jiraPluginCustomValidationMessageInterpolator,
            final ValidationProviderResolver hibernateValidationProviderResolver) {

        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationProviderResolver(hibernateValidationProviderResolver);
        localValidatorFactoryBean.setMessageInterpolator(jiraPluginCustomValidationMessageInterpolator);

        return localValidatorFactoryBean;
    }

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor(
            final LocalValidatorFactoryBean localValidatorFactoryBean) {

        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidator(localValidatorFactoryBean);

        return methodValidationPostProcessor;
    }

}