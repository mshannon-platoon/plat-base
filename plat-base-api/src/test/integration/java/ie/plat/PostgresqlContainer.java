package ie.plat;

import java.util.Map;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlContainer extends PostgreSQLContainer<PostgresqlContainer> {

  private static final String POSTGRES_IMAGE_VERSION = "postgres:13.3";

  private static PostgresqlContainer postgres = new PostgresqlContainer();

  private PostgresqlContainer() {
    super(POSTGRES_IMAGE_VERSION);
  }

  public static PostgresqlContainer getInstance() {
    if (postgres == null) {
      postgres = new PostgresqlContainer();
    }
    return postgres;
  }

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void stop() {
    //do nothing, JVM handles shut down
  }

  public Map<String, String> createConnectionConfiguration() {
    return Map.of(
        "spring.datasource.url", postgres.getJdbcUrl(),
        "spring.datasource.username", postgres.getUsername(),
        "spring.datasource.password", postgres.getPassword()
    );
  }
}
