package dev.lukaszmichalak.regionalproducts.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.time.*;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceTest {

  @Mock private VoivodeshipService voivodeshipService;

  @Mock private StatisticsRepository statisticsRepository;

  @Mock private Clock clock;

  @InjectMocks private StatisticsService statisticsService;

  @BeforeEach
  void setUp() {
    doReturn(Instant.parse("2025-01-01T19:00:00.00Z")).when(clock).instant();
    doReturn(ZoneId.systemDefault()).when(clock).getZone();
  }

  @Test
  void shouldIncrementExistingStatistics() {
    // Given
    VoivodeshipDto voivodeshipDto = VoivodeshipStub.dsDto();
    LocalDate now = LocalDate.now(clock);

    Statistics existingStatistics = new Statistics(1L, voivodeshipDto.id(), now, 5);

    doReturn(voivodeshipDto).when(voivodeshipService).getVoivodeshipByCode(voivodeshipDto.code());

    doReturn(Optional.of(existingStatistics))
        .when(statisticsRepository)
        .findByVoivodeshipIdAndDate(voivodeshipDto.id(), now);

    // When
    statisticsService.increment(voivodeshipDto.code());

    // Then
    verify(statisticsRepository).findByVoivodeshipIdAndDate(voivodeshipDto.id(), now);
    verify(statisticsRepository, never()).save(any());
    assertThat(existingStatistics.getCount()).isEqualTo(6);
  }

  @Test
  void shouldCreateNewStatisticsIfNotExist() {
    // Given
    VoivodeshipDto voivodeshipDto = VoivodeshipStub.dsDto();
    LocalDate now = LocalDate.now(clock);

    doReturn(voivodeshipDto).when(voivodeshipService).getVoivodeshipByCode(voivodeshipDto.code());

    doReturn(Optional.empty())
        .when(statisticsRepository)
        .findByVoivodeshipIdAndDate(voivodeshipDto.id(), now);

    // When
    statisticsService.increment(voivodeshipDto.code());

    // Then
    verify(statisticsRepository).findByVoivodeshipIdAndDate(voivodeshipDto.id(), now);
    verify(statisticsRepository)
        .save(
            argThat(
                statistics ->
                    statistics.getVoivodeshipId().equals(voivodeshipDto.id())
                        && statistics.getDate().equals(now)
                        && statistics.getCount() == 1));
  }
}
