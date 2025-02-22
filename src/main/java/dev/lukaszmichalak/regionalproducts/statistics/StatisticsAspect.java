package dev.lukaszmichalak.regionalproducts.statistics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
class StatisticsAspect {

  private final StatisticsService statisticsService;

  @Before("@annotation(StatisticsPerDay)")
  public void count(JoinPoint joinPoint) {

    Object[] args = joinPoint.getArgs();

    if (args.length == 2 && args[1] instanceof String code && code.length() == 2) {
      statisticsService.increment(code);
    } else {
      log.error("Cannot track statistics for {}", joinPoint.getSignature());
    }
  }
}
