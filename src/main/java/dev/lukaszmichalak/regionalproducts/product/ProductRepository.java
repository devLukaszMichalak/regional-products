package dev.lukaszmichalak.regionalproducts.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;

interface ProductRepository extends ListCrudRepository<Product, Long> {

  Optional<Product> findByName(String name);

  List<Product> findByVoivodeshipId(Long name);

  long countByVoivodeshipId(Long id);
}
