package dev.lukaszmichalak.regionalproducts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class RegionalProductsApplicationTests {

  @Test
  void contextLoads() {
    assertThat(true).isTrue();
  }
}
