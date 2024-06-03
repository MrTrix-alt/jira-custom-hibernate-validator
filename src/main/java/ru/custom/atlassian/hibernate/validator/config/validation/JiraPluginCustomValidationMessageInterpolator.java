package ru.custom.atlassian.hibernate.validator.config.validation;

import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.sal.api.message.I18nResolver;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.MessageInterpolator;
import java.util.Locale;
import java.util.Objects;

@Slf4j
public class JiraPluginCustomValidationMessageInterpolator extends ParameterMessageInterpolator {

    private final I18nResolver i18nResolver;
    private final JiraAuthenticationContext jiraAuthenticationContext;

    public JiraPluginCustomValidationMessageInterpolator(final I18nResolver i18nResolver,
            final JiraAuthenticationContext jiraAuthenticationContext) {
        this.i18nResolver = Objects.requireNonNull(i18nResolver, "i18nResolver");
        this.jiraAuthenticationContext = Objects.requireNonNull(jiraAuthenticationContext, "jiraAuthenticationContext");
    }


    @Override
    public String interpolate(String message, MessageInterpolator.Context context, Locale locale) {
        log.debug("JiraPluginCustomValidationMessageInterpolator#interpolate start");

        String text = this.i18nResolver.getText(message);
        if (text == null || text.equals(message)) {
            text = super.interpolate(message, context, jiraAuthenticationContext.getLocale());
        }

        log.debug("JiraPluginCustomValidationMessageInterpolator#interpolate end");
        return text;
    }

}
