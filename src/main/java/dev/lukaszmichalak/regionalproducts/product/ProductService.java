package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

  ProductDto getProductById(Long id);

  ProductDto getProductByName(String name);

  List<ProductDto> getProducts();

  List<ProductDto> getProductsOfVoivodeship(Long voivodeshipId);

  long countProductsOfVoivodeship(Long voivodeshipId);

  long getProductsCount();

  void updateAverageRating(Long productId, BigDecimal averageRating);
}
