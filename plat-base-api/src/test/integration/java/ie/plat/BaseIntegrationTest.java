package ie.plat;

import java.util.Map;
import java.util.stream.Stream;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.lifecycle.Startables;

@ContextConfiguration(initializers = BaseIntegrationTest.Initializer.class)
public class BaseIntegrationTest {

  public static class Initializer implements
      ApplicationContextInitializer<ConfigurableApplicationContext> {

    static PostgresqlContainer postgres = PostgresqlContainer.getInstance();

    private static void startContainers() {
      Startables.deepStart(Stream.of(postgres)).join();
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      startContainers();
      ConfigurableEnvironment environment = applicationContext.getEnvironment();
      MapPropertySource testcontainers = new MapPropertySource(
          "testcontainers", (Map) postgres.createConnectionConfiguration()
      );
      environment.getPropertySources().addFirst(testcontainers);
    }
  }

}
