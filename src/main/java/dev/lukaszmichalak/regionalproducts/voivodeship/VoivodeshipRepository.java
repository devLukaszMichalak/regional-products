package dev.lukaszmichalak.regionalproducts.voivodeship;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface VoivodeshipRepository extends JpaRepository<Voivodeship, Integer> {

  Optional<Voivodeship> findByCode(String code);
}
