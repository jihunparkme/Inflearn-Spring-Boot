package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class CommandLineBean {

    private final ApplicationArguments arguments;

    public CommandLineBean(ApplicationArguments arguments) {
        this.arguments = arguments;
    }

    @PostConstruct
    public void init() {
        log.info("source {}", List.of(arguments.getSourceArgs())); // [--url=devdb, --username=dev_user, --password=dev_pw, mode=on]
        log.info("optionNames {}", arguments.getOptionNames()); // [password, url, username]
        Set<String> optionNames = arguments.getOptionNames();
        for (String optionName : optionNames) {
            // password=[dev_pw], url=[devdb], username=[dev_user]
            log.info("option args {}={}", optionName, arguments.getOptionValues(optionName));
        }
    }
}