package dev.lukaszmichalak.regionalproducts.statistics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    
    Optional<Statistics> findByVoivodeshipIdAndDate(Integer voivodeshipId, LocalDate date);
}
