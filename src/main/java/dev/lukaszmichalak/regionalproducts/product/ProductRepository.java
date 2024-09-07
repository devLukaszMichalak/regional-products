package dev.lukaszmichalak.regionalproducts.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface ProductRepository extends JpaRepository<Product, Integer> {
    
    Optional<Product> findByName(String name);
    
    List<Product> findByVoivodeshipId(Integer name);
    
    int countByVoivodeshipId(Integer id);
}
