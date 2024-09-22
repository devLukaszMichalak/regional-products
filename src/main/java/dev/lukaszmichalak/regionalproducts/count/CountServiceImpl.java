package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CountServiceImpl implements CountService {
    
    final CountRepository countRepository;
    final ProductService productService;
    
    @Override
    public List<CountDto> getCounts() {
        return countRepository.getCounts().stream().map(Count::toDto).toList();
    }
    
    @Override
    public long getTotalCount() {
        return productService.getProductsCount();
    }
}
