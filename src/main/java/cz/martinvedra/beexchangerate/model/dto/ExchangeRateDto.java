package cz.martinvedra.beexchangerate.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExchangeRateDto(String shortName,
                              LocalDateTime validFrom,
                              String name,
                              String country,
                              BigDecimal move,
                              BigDecimal amount,
                              BigDecimal valBuy,
                              BigDecimal valSell,
                              BigDecimal valMid,
                              BigDecimal currBuy,
                              BigDecimal currSell,
                              BigDecimal currMid,
                              Integer version,
                              BigDecimal cnbMid,
                              BigDecimal ecbMid)
{ }
