package dev.lukaszmichalak.regionalproducts.statistics;

import dev.lukaszmichalak.regionalproducts.common.LocalDateConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "statistics")
class Statistics {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "voivodeship_id", nullable = false)
  private Integer voivodeshipId;

  @Convert(converter = LocalDateConverter.class)
  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "count", nullable = false)
  private Integer count;
}
