package cz.martinvedra.beexchangerate.client;

import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateClient {

    private final RestTemplate restTemplate;

    @Value("${com.erstegroup.developers.webapi.exchange-rate-url}")
    private String apiCsasUrl;

    public List<ExchangeRateDto> getExchangeRateFromApi() {
        ExchangeRateDto[] apiObject = restTemplate.getForObject(apiCsasUrl, ExchangeRateDto[].class);
        return List.of(apiObject);
    }
}
