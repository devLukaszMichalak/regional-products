package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.dto.ProductTypeDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ProductMapper {
    
    final VoivodeshipService voivodeshipService;
    
    ProductDto toDto(Product product) {
        
        var productTypeDto = new ProductTypeDto(product.getProductType().getName());
        
        VoivodeshipDto voivodeshipDto = voivodeshipService
                .getVoivodeshipById(product.getVoivodeshipId());
        
        return new ProductDto(
                product.getName(),
                productTypeDto,
                voivodeshipDto,
                product.getDateOfEntry()
        );
    }
}


