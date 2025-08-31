package cz.martinvedra.beexchangerate.service;

import cz.martinvedra.beexchangerate.client.ExchangeRateClient;
import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;
import cz.martinvedra.beexchangerate.model.entity.ExchangeRateEntity;
import cz.martinvedra.beexchangerate.model.repo.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    @Qualifier("csasClient")
    private final ExchangeRateClient client;

    @Override
    public List<ExchangeRateDto> getExchangeRates(boolean usedb) {
        if (usedb) {
            List<ExchangeRateEntity> exchangeRateEntities = exchangeRateRepository.findAll();
        } else {
            client.getExchangeRateFromApi();
        }
        return Collections.emptyList();
    }
}
