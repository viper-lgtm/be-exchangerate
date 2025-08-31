package cz.martinvedra.beexchangerate.service;

import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateService {

    List<ExchangeRateDto> getExchangeRates(boolean usedb);
}
