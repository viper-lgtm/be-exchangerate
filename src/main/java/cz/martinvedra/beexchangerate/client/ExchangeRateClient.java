package cz.martinvedra.beexchangerate.client;

import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;
import cz.martinvedra.beexchangerate.model.repo.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeRateClient {

    private final ExchangeRateRepository repo;
    private final RestTemplate restTemplate;

    @Value("${com.erstegroup.developers.webapi.exchange-rate-url}")
    private String apiCsasUrl;

    public ExchangeRateDto[] getExchangeRateFromApi() {
        return restTemplate.getForObject(apiCsasUrl, ExchangeRateDto[].class);
    }
}
