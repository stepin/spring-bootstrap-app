package name.stepin.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.stepin.config.ApplicationProperties;
import name.stepin.service.ExampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleResource {

    private final ExampleService exampleService;
    private final ApplicationProperties applicationProperties;
    @Value("${git.branch}")
    private String gitBranch;

    @GetMapping(value = "", produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnMetrics() {
        log.info("returnMetrics");
        return exampleService.dateString();
    }

    @GetMapping(value = "app_config", produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnAppConfig() {
        log.info("returnAppConfig");
        return "exampleTimerFixedDelayMs: " + applicationProperties.getExampleTimerFixedDelayMs();
    }

    @GetMapping(value = "git_branch", produces = MediaType.TEXT_PLAIN_VALUE)
    public String returnGitBranch() {
        log.info("returnGitBranch");
        return "git_branch: " + gitBranch;
    }
}
