package cz.martinvedra.beexchangerate.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchangerate")
@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortName;
    private LocalDateTime validFrom;
    private String name;
    private String country;
    private BigDecimal move;
    private BigDecimal amount;
    private BigDecimal valBuy;
    private BigDecimal valSell;
    private BigDecimal valMid;
    private BigDecimal currBuy;
    private BigDecimal currSell;
    private BigDecimal currMid;
    private Integer version;
    private BigDecimal cnbMid;
    private BigDecimal ecbMid;
}
