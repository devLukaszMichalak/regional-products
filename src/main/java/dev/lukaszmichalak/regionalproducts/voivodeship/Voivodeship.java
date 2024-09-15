package dev.lukaszmichalak.regionalproducts.voivodeship;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voivodeship")
class Voivodeship {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "code", nullable = false)
    private String code;
    
    @Column(name = "description_en", nullable = false)
    private String descriptionEn;
    
    @Column(name = "description_pl", nullable = false)
    private String descriptionPl;
    
    @Column(name = "coat_of_arms_filename", nullable = false)
    private String coatOfArmsFilename;
    
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}
