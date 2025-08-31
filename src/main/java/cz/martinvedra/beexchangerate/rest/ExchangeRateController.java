package cz.martinvedra.beexchangerate.rest;

import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateController {

List<ExchangeRateDto> getExchangeRates(boolean usedb);
}
