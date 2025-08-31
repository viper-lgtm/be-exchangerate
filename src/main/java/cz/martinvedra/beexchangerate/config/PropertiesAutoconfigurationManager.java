package cz.martinvedra.beexchangerate.config;

import cz.martinvedra.beexchangerate.client.ExchangeRateClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(PropertiesConfigurationProperties.class)
@ConditionalOnProperty(prefix = PropertiesConfigurationProperties.PREFIX_NAME, value = "enabled", matchIfMissing = true)
public class PropertiesAutoconfigurationManager {

    @Bean(name = "csasClient")
    @ConditionalOnMissingBean(name = "csasClient" )
    public ExchangeRateClient csasClient() {
        return new ExchangeRateClient(new RestTemplate());
    }

    @Bean(name = "restTemplate")
    @ConditionalOnMissingBean(name = "restTemplate" )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
