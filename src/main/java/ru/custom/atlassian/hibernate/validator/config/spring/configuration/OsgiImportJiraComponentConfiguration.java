package ru.custom.atlassian.hibernate.validator.config.spring.configuration;

import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.plugins.osgi.javaconfig.OsgiServices;
import com.atlassian.sal.api.message.I18nResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OsgiImportJiraComponentConfiguration {

    @Bean
    I18nResolver i18nResolver() {
        return OsgiServices.importOsgiService(I18nResolver.class);
    }

    @Bean
    JiraAuthenticationContext jiraAuthenticationContext() {
        return OsgiServices.importOsgiService(JiraAuthenticationContext.class);
    }

}
