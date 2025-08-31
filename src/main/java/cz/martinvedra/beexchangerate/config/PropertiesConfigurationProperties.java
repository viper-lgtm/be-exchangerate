package cz.martinvedra.beexchangerate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = PropertiesConfigurationProperties.PREFIX_NAME)
public record PropertiesConfigurationProperties(
        @DefaultValue("true") boolean enabled,
        String exchangeRateUrl
) {
    public static final String PREFIX_NAME = "com.erstegroup.developers.webapi";
}
