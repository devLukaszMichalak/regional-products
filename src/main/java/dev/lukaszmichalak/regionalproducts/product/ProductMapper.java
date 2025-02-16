package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ProductMapper {

  ProductDto toDto(Product product) {

    return new ProductDto(
        product.getId(),
        product.getName(),
        product.getProductType().getName(),
        product.getDateOfEntry(),
        product.getAverageRating().doubleValue());
  }
}
