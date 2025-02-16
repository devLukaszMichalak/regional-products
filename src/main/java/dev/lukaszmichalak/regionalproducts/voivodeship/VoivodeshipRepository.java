package dev.lukaszmichalak.regionalproducts.voivodeship;

import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;

interface VoivodeshipRepository extends ListCrudRepository<Voivodeship, Integer> {

  Optional<Voivodeship> findByCodeIgnoreCase(String code);
}
