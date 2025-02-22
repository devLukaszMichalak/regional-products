package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public ProductDto getProductById(Long id) {
    return productRepository
        .findById(id)
        .map(ProductMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Override
  public ProductDto getProductByName(String name) {
    return productRepository
        .findByName(name)
        .map(ProductMapper::toDto)
        .orElseThrow(() -> new ProductNotFoundException(name));
  }

  @Override
  public List<ProductDto> getProducts() {
    return productRepository.findAll().stream().map(ProductMapper::toDto).toList();
  }

  @Override
  public List<ProductDto> getProductsOfVoivodeship(Long voivodeshipId) {
    return productRepository.findByVoivodeshipId(voivodeshipId).stream()
        .map(ProductMapper::toDto)
        .toList();
  }

  @Override
  public long countProductsOfVoivodeship(Long voivodeshipId) {
    return productRepository.countByVoivodeshipId(voivodeshipId);
  }

  @Override
  public long getProductsCount() {
    return productRepository.count();
  }

  @Override
  public void updateAverageRating(Long productId, BigDecimal averageRating) {
    Product product =
        productRepository
            .findById(productId)
            .orElseThrow(() -> new ProductNotFoundException(productId));
    product.setAverageRating(averageRating);
    productRepository.save(product);
  }
}
