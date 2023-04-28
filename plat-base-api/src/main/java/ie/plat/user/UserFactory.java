package ie.plat.user;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserFactory {

  public User createUserFromDTO(UserDTO userDTO) {
    return User
        .builder()
        .username(userDTO.getUsername())
        .email(userDTO.getEmail())
        .password(userDTO.getPassword())
        .mobileNumber(userDTO.getMobileNumber())
        .roles(userDTO.getRoles())
        .build();
  }

  public UserDTO createUserDTOFromUser(User user) {
    return UserDTO
        .builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .password(user.getPassword())
        .mobileNumber(user.getMobileNumber())
        .roles(user.roles())
        .build();
  }

}
