package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TestProductService implements ProductService {

  private final ProductMapper productMapper;

  private static final Map<Long, Product> products = new HashMap<>();

  static {
    products.put(1L, ProductStub.honey);
    products.put(2L, ProductStub.wine);
  }

  @Override
  public ProductDto getProductById(final Long id) {
    return Optional.ofNullable(products.get(id))
        .map(productMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public ProductDto getProductByName(final String name) {
    return products.values().stream()
        .filter(p -> name.equals(p.getName()))
        .findFirst()
        .map(productMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(name));
  }

  @Override
  public List<ProductDto> getProducts() {
    return products.values().stream().map(productMapper::toDto).toList();
  }

  @Override
  public List<ProductDto> getProductsOfVoivodeship(final Long voivodeshipId) {
    return products.values().stream()
        .filter(p -> voivodeshipId.equals(p.getVoivodeshipId()))
        .map(productMapper::toDto)
        .toList();
  }

  @Override
  public long countProductsOfVoivodeship(final Long voivodeshipId) {
    return products.values().stream()
        .filter(p -> voivodeshipId.equals(p.getVoivodeshipId()))
        .count();
  }

  @Override
  public long getProductsCount() {
    return products.size();
  }
  
  @Override
  public void updateAverageRating(Long productId, BigDecimal averageRating) {
    Product product = products.get(productId);
    product.setAverageRating(averageRating);
  }
  
}
