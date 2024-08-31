package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    
    ProductDto getProductById(Integer id);
    
    ProductDto getProductByName(String name);
    
    List<ProductDto> getProducts();
    
    List<ProductDto> getProductsOfVoivodeship(Integer voivodeshipId);
}
