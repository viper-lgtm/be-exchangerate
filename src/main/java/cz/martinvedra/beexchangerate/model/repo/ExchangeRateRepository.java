package cz.martinvedra.beexchangerate.model.repo;

import cz.martinvedra.beexchangerate.model.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity,Long> {
}
