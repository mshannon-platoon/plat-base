package ie.plat.user;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public HttpStatus createUserFromDTO(UserDTO userDTO) {
    userRepository.save(UserFactory.createUserFromDTO(userDTO));
    return HttpStatus.CREATED;
  }

  public Optional<UserDTO> getUser(Integer userId) {
    return userRepository
        .findById(userId)
        .map(UserFactory::createUserDTOFromUser);
  }
}
