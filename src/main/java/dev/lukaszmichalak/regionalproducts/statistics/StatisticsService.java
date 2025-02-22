package dev.lukaszmichalak.regionalproducts.statistics;

import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import jakarta.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StatisticsService {

  private final VoivodeshipService voivodeshipService;
  private final StatisticsRepository statisticsRepository;
  private final Clock clock;

  @Transactional
  void increment(String voivodeshipCode) {
    var voivodeship = voivodeshipService.getVoivodeshipByCode(voivodeshipCode);

    LocalDate currentDate = LocalDate.now(clock);

    statisticsRepository
        .findByVoivodeshipIdAndDate(voivodeship.id(), currentDate)
        .ifPresentOrElse(
            statistics -> statistics.setCount(statistics.getCount() + 1),
            () -> {
              Statistics statistics = new Statistics();
              statistics.setVoivodeshipId(voivodeship.id());
              statistics.setDate(currentDate);
              statistics.setCount(1);
              statisticsRepository.save(statistics);
            });
  }
}
