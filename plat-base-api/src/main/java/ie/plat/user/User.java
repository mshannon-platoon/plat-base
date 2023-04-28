package ie.plat.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
  @SequenceGenerator(name = "generator", sequenceName = "user_seq", allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "mobile_number")
  private String mobileNumber;

  /**
   * Roles should be comma seperated and using the ROLES_ENUM
   */
  @Column(name = "roles")
  @Getter(AccessLevel.NONE)
  private String roles;

  @Column(name = "created_time")
  @CreationTimestamp
  private Date createdTime;

  @Column(name = "last_updated_at")
  @UpdateTimestamp
  private Date lastUpdatedAt;

  public String roles() {
    return roles;
  }

  public List<String> getRoles() {
    String[] rolesSplit = roles.split(",");
    if (roles.length() > 1) {
      return Arrays.stream(rolesSplit).toList();
    } else {
      return List.of(roles);
    }
  }

}
