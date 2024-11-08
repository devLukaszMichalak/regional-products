package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class TestProductService implements ProductService {

  private static final Map<Integer, ProductDto> products = new HashMap<>();

  static {
    var p1 =
        new ProductDto("Miód wrzosowy z Borów Dolnośląskich", "Miody", LocalDate.of(2005, 9, 25));
    var p2 =
        new ProductDto(
            "Wino śląskie", "Napoje (alkoholowe i bezalkoholowe)", LocalDate.of(2007, 6, 11));

    products.put(1, p1);
    products.put(2, p2);
  }

  @Override
  public ProductDto getProductById(Integer id) {
    return Optional.ofNullable(products.get(id))
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public ProductDto getProductByName(String name) {
    return products.values().stream()
        .filter(p -> name.equals(p.name()))
        .findFirst()
        .orElseThrow(() -> new ProductNotFoundException(name));
  }

  @Override
  public List<ProductDto> getProducts() {
    return products.values().stream().toList();
  }

  @Override
  public List<ProductDto> getProductsOfVoivodeship(Integer voivodeshipId) {
    return products.values().stream().limit(1).toList();
  }

  @Override
  public long countProductsOfVoivodeship(Integer voivodeshipId) {
    return products.values().stream().limit(1).count();
  }

  @Override
  public long getProductsCount() {
    return products.size();
  }
}
