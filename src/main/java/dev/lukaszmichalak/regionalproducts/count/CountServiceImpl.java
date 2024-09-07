package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountServiceImpl implements CountService {
    
    final ProductService productService;
    final VoivodeshipService voivodeshipService;
    
    @Override
    public List<CountDto> getCounts() {
        
        return voivodeshipService.getVoivodeships()
                .stream()
                .map(v -> new CountDto(v.name(), productService.countProductsOfVoivodeship(v.id())))
                .toList();
    }
}
