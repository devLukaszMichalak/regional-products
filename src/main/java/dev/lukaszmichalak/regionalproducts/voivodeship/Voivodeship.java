package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.common.LocalDateTimeConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voivodeship")
class Voivodeship {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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
  
  @Convert(converter = LocalDateTimeConverter.class)
  @Column(name = "creation_date", nullable = false, insertable = false, updatable = false)
  private LocalDateTime creationDate;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Voivodeship voivodeship = (Voivodeship) o;
    return Objects.equals(id, voivodeship.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
