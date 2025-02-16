package dev.lukaszmichalak.regionalproducts.security.user;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RegistrationServiceImpl implements RegistrationService {

  private final UserDetailsManager userDetailsManager;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  @Override
  public boolean doesUserExists(String username) {
    return userDetailsManager.userExists(username);
  }

  @Override
  public void register(String username, String password, HttpSession session) {

    userDetailsManager.createUser(new User(username, passwordEncoder.encode(password)));

    var unauthenticated = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
    var registered = authenticationManager.authenticate(unauthenticated);

    var securityContext = SecurityContextHolder.getContext();
    securityContext.setAuthentication(registered);

    session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
  }
}
