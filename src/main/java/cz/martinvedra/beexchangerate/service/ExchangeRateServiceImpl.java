package cz.martinvedra.beexchangerate.service;

import cz.martinvedra.beexchangerate.client.ExchangeRateClient;
import cz.martinvedra.beexchangerate.model.dto.ExchangeRateDto;
import cz.martinvedra.beexchangerate.model.entity.ExchangeRateEntity;
import cz.martinvedra.beexchangerate.model.repo.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository repo;
    private final ExchangeRateClient client;
    private final InnerMapper innerMapper;

    @Override
    public List<ExchangeRateDto> getExchangeRates(boolean usedb) {
        if (usedb) {
            List<ExchangeRateEntity> exchangeRateEntities = repo.findAll();
            return exchangeRateEntities.stream()
                    .map(innerMapper::toDtos)
                    .toList();
        } else {
            ExchangeRateDto[] apiObjects = client.getExchangeRateFromApi();

            Arrays.stream(apiObjects)
                    .map(innerMapper::toEntity)
                    .forEach(repo::save);
            return Arrays.asList(apiObjects);
        }
    }

    @Mapper(builder = @Builder(disableBuilder = true))
    public abstract static class InnerMapper {

        @Mapping(target = "id", ignore = true)
        protected abstract ExchangeRateEntity toEntity(ExchangeRateDto exchangeRateDto);

        protected abstract ExchangeRateDto toDtos(ExchangeRateEntity exchangeRateEntity);
    }
}
