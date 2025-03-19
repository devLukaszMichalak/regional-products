package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.cache.CacheName;
import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CountServiceImpl implements CountService {

  private final CountRepository countRepository;
  private final ProductService productService;

  @Override
  @Cacheable(CacheName.COUNT_SERVICE_GET_COUNTS)
  public List<CountDto> getCounts() {
    return countRepository.getCounts().stream().map(Count::toDto).toList();
  }

  @Override
  public long getTotalCount() {
    return productService.getProductsCount();
  }
}
