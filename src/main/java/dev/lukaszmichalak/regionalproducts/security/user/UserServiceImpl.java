package dev.lukaszmichalak.regionalproducts.security.user;

import dev.lukaszmichalak.regionalproducts.security.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDto getUser(String username) {
    return userRepository
        .findUserByUsername(username)
        .map(user -> new UserDto(user.getId(), user.getUsername()))
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
