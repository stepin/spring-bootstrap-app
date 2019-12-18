package name.stepin.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

class CORSFilterTest {

  @Test
  void checkHeaders() throws ServletException, IOException {
    Filter corsFilter = new CORSFilter();
    ServletRequest request = mock(ServletRequest.class);
    HttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);

    corsFilter.init(null);
    corsFilter.doFilter(request, response, chain);
    corsFilter.destroy();

    verify(chain).doFilter(request, response);
    assertThat(response.getHeaderNames()).hasSize(4);
    assertThat(response.getHeader("Access-Control-Allow-Origin")).isEqualTo("*");
    assertThat(response.getHeader("Access-Control-Allow-Methods")).isEqualTo("*");
    assertThat(response.getHeader("Access-Control-Allow-Headers")).isEqualTo("*");
    assertThat(response.getHeader("Access-Control-Max-Age")).isEqualTo("3600");
  }
}
