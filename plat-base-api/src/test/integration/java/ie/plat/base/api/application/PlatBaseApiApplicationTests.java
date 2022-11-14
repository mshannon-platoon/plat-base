package ie.plat.base.api.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Testcontainers
@ActiveProfiles("test-containers")
class PlatBaseApiApplicationTests {

  @Test
  void contextLoads() {
  }

}
