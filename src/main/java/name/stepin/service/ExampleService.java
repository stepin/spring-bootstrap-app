package name.stepin.service;


import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    public String dateString() {
        return LocalDateTime.now().toString();
    }

}
