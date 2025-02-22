package dev.lukaszmichalak.regionalproducts.security.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

interface UserRepository extends ListCrudRepository<User, Long> {

  Optional<User> findUserByUsername(String username);
  
  void deleteUserByUsername(String username);
  
  @Transactional
  @Modifying
  @Query("UPDATE User u SET u.username = ?1, u.password = ?2 WHERE u.id = ?3")
  void updateUsernameAndPasswordById(String username, String password, Long id);
}
