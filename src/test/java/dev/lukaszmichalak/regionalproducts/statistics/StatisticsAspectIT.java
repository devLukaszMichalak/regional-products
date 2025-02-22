package dev.lukaszmichalak.regionalproducts.statistics;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
@Import(StatisticsAspectIT.TestService.class)
@Execution(ExecutionMode.SAME_THREAD)
class StatisticsAspectIT {

  @MockitoBean private StatisticsService statisticsService;

  @Autowired private TestService testService;

  @Test
  void shouldNotIncrementStatisticsWhenInvalidCodeIsProvided() {
    // Given
    String invalidCode = "USA";

    // When
    testService.someTrackedMethod(42, invalidCode);

    // Then
    verify(statisticsService, never()).increment(anyString());
  }

  @Test
  void shouldIncrementStatisticsWhenValidCodeIsProvided() {
    // Given
    String validCode = "DS";

    // When
    testService.someTrackedMethod(42, validCode);

    // Then
    verify(statisticsService, times(1)).increment(validCode);
  }

  @Service
  static class TestService {

    @StatisticsPerDay
    public void someTrackedMethod(int number, String code) {}
  }
}
