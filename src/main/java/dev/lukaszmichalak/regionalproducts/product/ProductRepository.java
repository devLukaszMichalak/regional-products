package dev.lukaszmichalak.regionalproducts.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Integer> {

  Optional<Product> findByName(String name);

  List<Product> findByVoivodeshipId(Integer name);

  long countByVoivodeshipId(Integer id);
}
