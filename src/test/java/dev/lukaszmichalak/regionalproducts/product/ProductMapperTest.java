package dev.lukaszmichalak.regionalproducts.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ProductMapperTest {

  @Test
  void testMapping() {
    var honey = ProductStub.honey;

    var honeyDto = ProductMapper.toDto(honey);

    assertThat(honeyDto).isNotNull();
    assertThat(honeyDto.id()).isEqualTo(honey.getId());
    assertThat(honeyDto.name()).isEqualTo(honey.getName());
    assertThat(honeyDto.averageRating()).isEqualTo(honey.getAverageRating().doubleValue());
    assertThat(honeyDto.productTypeName()).isEqualTo(honey.getProductType().getName());
    assertThat(honeyDto.dateOfEntry()).isEqualTo(honey.getDateOfEntry());
  }
}
