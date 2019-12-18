package name.stepin.service;


import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

  @Transactional(readOnly = true)
  public String dateString() {
    return LocalDateTime.now().toString();
  }

  @Transactional
  public String create(String date) {
    return date;
  }

}
