package ie.plat.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId) {
    log.debug("UserController - getUser - userId: {}", userId);
    try {
      return userService
          .getUser(userId)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.noContent().build());
    } catch (Exception e) {
      log.error("Exception thrown trying to get user: {}", userId);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/user")
  public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
    log.debug("UserController - createUser - userDTO: {}", userDTO);
    try {
      return ResponseEntity.status(userService.createUserFromDTO(userDTO)).build();
    } catch (Exception e) {
      log.error("Exception thrown trying to create user: {}", userDTO);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
