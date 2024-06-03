package ru.custom.atlassian.hibernate.validator.config.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.custom.atlassian.hibernate.validator.config.service.DemoValidationService;
import ru.custom.atlassian.hibernate.validator.config.service.DummyService;

@Configuration
@PropertySource("osgibundlejar:/ru/custom/atlassian/hibernate/validator/config/spring-plugin.properties")
public class ServiceConfiguration {

    @Bean
    DemoValidationService demoValidationService() {
        return new DemoValidationService();
    }

    @Bean
    DummyService dummyService() {
        return new DummyService();
    }


}
