package dev.lukaszmichalak.regionalproducts.security.user;

import dev.lukaszmichalak.regionalproducts.security.user.exceptions.PasswordChangeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DatabaseUserDetailsManager implements UserDetailsManager {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void createUser(UserDetails user) {
    userRepository.save((User) user);
  }

  @Override
  public void updateUser(UserDetails user) {
    userRepository.updateUsernameAndPasswordById(
        user.getUsername(), user.getPassword(), ((User) user).getId());
  }

  @Override
  public void deleteUser(String username) {
    userRepository.deleteUserByUsername(username);
  }

  @Override
  public void changePassword(String oldPassword, String newPassword)
      throws PasswordChangeException {
    throw new PasswordChangeException("Password change not supported!");
  }

  @Override
  public boolean userExists(String username) {
    return userRepository.findUserByUsername(username).isPresent();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
