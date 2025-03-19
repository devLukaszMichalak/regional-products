package dev.lukaszmichalak.regionalproducts.cache;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CacheCleaner {

  private final CacheManager cacheManager;

  @Scheduled(cron = "0 0 3 * * *")
  public void evictCachesAt3Am() {
    cacheManager.getCacheNames().stream()
        .map(cacheManager::getCache)
        .filter(Objects::nonNull)
        .forEach(Cache::clear);
  }
}
