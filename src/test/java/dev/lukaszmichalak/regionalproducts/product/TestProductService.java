package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TestProductService implements ProductService {

  private final ProductMapper productMapper;

  private static final Map<Integer, Product> products = new HashMap<>();

  static {
    var p1 =
        new Product(
            1,
            "Miód wrzosowy z Borów Dolnośląskich",
            new ProductType(1, "Miody", LocalDateTime.of(2024, 1, 1, 12, 0)),
            1,
            LocalDate.of(2024, 1, 1),
            LocalDateTime.of(2024, 1, 1, 12, 0));

    var p2 =
        new Product(
            2,
            "Wino śląskie",
            new ProductType(
                2, "Napoje (alkoholowe i bezalkoholowe)", LocalDateTime.of(2024, 1, 1, 12, 0)),
            1,
            LocalDate.of(2024, 1, 1),
            LocalDateTime.of(2024, 1, 1, 12, 0));

    products.put(1, p1);
    products.put(2, p2);
  }

  @Override
  public ProductDto getProductById(final Integer id) {
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
  public List<ProductDto> getProductsOfVoivodeship(final Integer voivodeshipId) {
    return products.values().stream()
        .filter(p -> voivodeshipId.equals(p.getVoivodeshipId()))
        .map(productMapper::toDto)
        .toList();
  }

  @Override
  public long countProductsOfVoivodeship(final Integer voivodeshipId) {
    return products.values().stream()
        .filter(p -> voivodeshipId.equals(p.getVoivodeshipId()))
        .count();
  }

  @Override
  public long getProductsCount() {
    return products.size();
  }
}
