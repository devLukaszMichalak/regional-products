package dev.lukaszmichalak.regionalproducts.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.NonNull;

interface ProductRepository extends ListCrudRepository<Product, Long> {

  @NonNull
  @Override
  @EntityGraph(attributePaths = {"productType"})
  Optional<Product> findById(@NonNull Long id);
  
  Optional<Product> findWithoutRelationsById(@NonNull Long id);

  @NonNull
  @Override
  @EntityGraph(attributePaths = {"productType"})
  List<Product> findAll();

  @EntityGraph(attributePaths = {"productType"})
  Optional<Product> findByName(String name);

  @EntityGraph(attributePaths = {"productType"})
  List<Product> findByVoivodeshipId(Long name);

  long countByVoivodeshipId(Long id);
}
