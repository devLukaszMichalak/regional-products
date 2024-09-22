package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {
    
    final ProductRepository productRepository;
    final ProductMapper productMapper;
    
    @Override
    public ProductDto getProductById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    
    @Override
    public ProductDto getProductByName(String name) {
        return productRepository.findByName(name)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(name));
    }
    
    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
    
    @Override
    public List<ProductDto> getProductsOfVoivodeship(Integer voivodeshipId) {
        return productRepository.findByVoivodeshipId(voivodeshipId)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }
    
    @Override
    public long countProductsOfVoivodeship(Integer voivodeshipId) {
        return productRepository.countByVoivodeshipId(voivodeshipId);
    }
    
    @Override
    public long getProductsCount() {
        return productRepository.count();
    }
}
