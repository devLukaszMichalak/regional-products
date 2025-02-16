package dev.lukaszmichalak.regionalproducts.statistics;

import dev.lukaszmichalak.regionalproducts.common.LocalDateConverter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.*;

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
  private Long id;

  @Column(name = "voivodeship_id", nullable = false)
  private Long voivodeshipId;

  @Convert(converter = LocalDateConverter.class)
  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "count", nullable = false)
  private Integer count;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics statistics = (Statistics) o;
    return Objects.equals(id, statistics.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
