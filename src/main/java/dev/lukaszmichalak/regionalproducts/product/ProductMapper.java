package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;

class ProductMapper {

  static ProductDto toDto(Product product) {

    return new ProductDto(
        product.getId(),
        product.getName(),
        product.getProductType().getName(),
        product.getDateOfEntry(),
        product.getAverageRating().doubleValue());
  }
}
