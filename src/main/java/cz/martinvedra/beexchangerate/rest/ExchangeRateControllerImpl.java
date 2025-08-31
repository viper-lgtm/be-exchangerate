package cz.martinvedra.beexchangerate.rest;

import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;
import cz.martinvedra.beexchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExchangeRateControllerImpl implements ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping
    @Override
    public List<ExchangeRateDto> getExchangeRates(@RequestParam boolean usedb) {
        return exchangeRateService.getExchangeRates(usedb);
    }
}
