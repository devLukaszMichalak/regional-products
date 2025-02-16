package dev.lukaszmichalak.regionalproducts.security.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

interface UserRepository extends ListCrudRepository<User, Long> {

  Optional<User> findUserByUsername(String username);

  void deleteUserByUsername(String username);

  @Modifying
  @Query("update User u set u.username = ?1, u.password = ?2 where u.id = ?3")
  void updateUsernameAndPasswordById(String username, String password, Long id);
}
