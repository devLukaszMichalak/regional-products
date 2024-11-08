package dev.lukaszmichalak.regionalproducts.product;

public class TestProductConfig {

  public static ProductService productService() {
    return new TestProductService();
  }
}
