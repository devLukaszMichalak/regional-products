package dev.lukaszmichalak.regionalproducts.voivodeship;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface VoivodeshipRepository extends JpaRepository<Voivodeship, Integer> {
    
    Optional<Voivodeship> findByCode(String code);
}
