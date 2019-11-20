package name.stepin.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import name.stepin.config.ApplicationProperties;
import name.stepin.config.GitInfo;
import name.stepin.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ExampleResource.class)
public class ExampleResourceTests {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ExampleService service;

  @MockBean
  private ApplicationProperties applicationProperties;

  @MockBean
  private GitInfo gitInfo;

  @Test
  public void exampleResource_whenGet_thenReturnTextDate()
      throws Exception {

    given(service.dateString()).willReturn("myDate");

    mvc.perform(get("/example")
        .contentType(MediaType.TEXT_PLAIN_VALUE))
        .andExpect(status().isOk())
        .andExpect(content().string("myDate"));
  }
}
