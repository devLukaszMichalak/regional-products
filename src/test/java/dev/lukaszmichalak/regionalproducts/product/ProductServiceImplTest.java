package dev.lukaszmichalak.regionalproducts.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

  @Mock private ProductRepository productRepository;

  @InjectMocks private ProductServiceImpl productService;

  private Product product;
  private ProductDto productDto;

  @BeforeEach
  void setUp() {
    ProductType productType = new ProductType(1L, "Test Type", LocalDateTime.of(2025, 1, 1, 12, 0));

    product =
        new Product(
            1L,
            "Test Product",
            productType,
            1L,
            LocalDate.now(),
            LocalDateTime.now(),
            BigDecimal.valueOf(4.5));

    productDto = ProductMapper.toDto(product);
  }

  @Test
  void shouldReturnProductById() {
    when(productRepository.findById(1L)).thenReturn(Optional.of(product));

    ProductDto result = productService.getProductById(1L);

    assertThat(result).usingRecursiveComparison().isEqualTo(productDto);
    verify(productRepository).findById(1L);
  }

  @Test
  void shouldThrowExceptionWhenProductNotFoundById() {
    when(productRepository.findById(1L)).thenReturn(Optional.empty());

    assertThatThrownBy(() -> productService.getProductById(1L))
        .isInstanceOf(ProductNotFoundException.class);
    verify(productRepository).findById(1L);
  }

  @Test
  void shouldReturnProductByName() {
    when(productRepository.findByName("Test Product")).thenReturn(Optional.of(product));

    ProductDto result = productService.getProductByName("Test Product");

    assertThat(result).usingRecursiveComparison().isEqualTo(productDto);
    verify(productRepository).findByName("Test Product");
  }

  @Test
  void shouldThrowExceptionWhenProductNotFoundByName() {
    when(productRepository.findByName("Test Product")).thenReturn(Optional.empty());

    assertThatThrownBy(() -> productService.getProductByName("Test Product"))
        .isInstanceOf(ProductNotFoundException.class);
    verify(productRepository).findByName("Test Product");
  }

  @Test
  void shouldReturnAllProducts() {
    when(productRepository.findAll()).thenReturn(List.of(product));

    List<ProductDto> result = productService.getProducts();

    assertThat(result).hasSize(1).first().usingRecursiveComparison().isEqualTo(productDto);
    verify(productRepository).findAll();
  }

  @Test
  void shouldReturnAllProductsOfVoivodeship() {
    when(productRepository.findByVoivodeshipId(1L)).thenReturn(List.of(product));

    List<ProductDto> result = productService.getProductsOfVoivodeship(1L);

    assertThat(result).hasSize(1).first().usingRecursiveComparison().isEqualTo(productDto);
    verify(productRepository).findByVoivodeshipId(1L);
  }

  @Test
  void shouldReturnEmptyListWhenNoProductsOfVoivodeship() {
    when(productRepository.findByVoivodeshipId(1L)).thenReturn(List.of());

    List<ProductDto> result = productService.getProductsOfVoivodeship(1L);

    assertThat(result).isEmpty();
    verify(productRepository).findByVoivodeshipId(1L);
  }

  @Test
  void shouldReturnCountOfProductsOfVoivodeship() {
    when(productRepository.countByVoivodeshipId(1L)).thenReturn(1L);

    long result = productService.countProductsOfVoivodeship(1L);

    assertThat(result).isEqualTo(1L);
    verify(productRepository).countByVoivodeshipId(1L);
  }

  @Test
  void shouldReturnProductsCount() {
    when(productRepository.count()).thenReturn(1L);

    long result = productService.getProductsCount();

    assertThat(result).isEqualTo(1L);
    verify(productRepository).count();
  }

  @Test
  void shouldUpdateAverageRating() {
    when(productRepository.findById(1L)).thenReturn(Optional.of(product));
    when(productRepository.save(any(Product.class))).thenReturn(product);

    productService.updateAverageRating(1L, BigDecimal.valueOf(4.0));

    assertThat(product.getAverageRating()).isEqualTo(BigDecimal.valueOf(4.0));
    verify(productRepository).findById(1L);
    verify(productRepository).save(product);
  }

  @Test
  void shouldThrowExceptionWhenUpdatingRatingOfNonExistingProduct() {
    when(productRepository.findById(1L)).thenReturn(Optional.empty());

    assertThatThrownBy(() -> productService.updateAverageRating(1L, BigDecimal.valueOf(4.0)))
        .isInstanceOf(ProductNotFoundException.class);
    verify(productRepository).findById(1L);
    verify(productRepository, never()).save(any(Product.class));
  }
}
