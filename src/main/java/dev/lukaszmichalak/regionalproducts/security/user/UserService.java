package dev.lukaszmichalak.regionalproducts.security.user;

import dev.lukaszmichalak.regionalproducts.security.user.dto.UserDto;

public interface UserService {

  UserDto getUser(String username);
}
