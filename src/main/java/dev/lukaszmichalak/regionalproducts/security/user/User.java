package dev.lukaszmichalak.regionalproducts.security.user;

import dev.lukaszmichalak.regionalproducts.common.LocalDateTimeConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @Getter(AccessLevel.PACKAGE)
  private Long id;

  @Getter
  @Column(name = "username", nullable = false)
  private String username;

  @Getter
  @Setter(AccessLevel.PACKAGE)
  @Column(name = "password", nullable = false)
  private String password;

  @Convert(converter = LocalDateTimeConverter.class)
  @Column(name = "creation_date", nullable = false, insertable = false, updatable = false)
  private LocalDateTime creationDate;

  User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
