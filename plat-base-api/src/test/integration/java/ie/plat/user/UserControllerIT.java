package ie.plat.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ie.plat.BaseIntegrationTest;
import ie.plat.PlatBaseApiApplication;
import ie.plat.util.TestUtils;
import javax.json.JsonObject;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    PlatBaseApiApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ActiveProfiles("integration")
class UserControllerIT extends BaseIntegrationTest {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private UserRepository userRepository;

  private MockMvc mockMvc;

  @BeforeEach
  public void beforeEach() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(context)
        .build();

    userRepository.deleteAll();
  }

  @Test
  void testGetUser_noUsers() throws Exception {
    MvcResult mvcResult = this.mockMvc
        .perform(get("/v1/users/1000")
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andReturn();

    assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
  }

  @Test
  void testGetUser() throws Exception {
    User user = userRepository.save(TestUtils.createUser());

    MvcResult mvcResult = this.mockMvc
        .perform(get("/v1/user/" + user.getId())
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

    assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/data/create-user.json")
  void testPostUser(JsonObject jsonObject) throws Exception {
    var request = post("/v1/user")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonObject.toString());

    mockMvc.perform(request).andExpect(status().isCreated());
  }

}
