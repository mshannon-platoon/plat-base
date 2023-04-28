package ie.plat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PlatBaseApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlatBaseApiApplication.class, args);
  }

}
