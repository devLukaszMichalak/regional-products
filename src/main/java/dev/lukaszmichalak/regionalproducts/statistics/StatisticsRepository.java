package dev.lukaszmichalak.regionalproducts.statistics;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;

interface StatisticsRepository extends ListCrudRepository<Statistics, Long> {

  Optional<Statistics> findByVoivodeshipIdAndDate(Long voivodeshipId, LocalDate date);
}
