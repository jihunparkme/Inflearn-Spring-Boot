package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            // --url=devdb --username=dev_user --password=dev_pw mode=on
            log.info("arg {}", arg);
        }

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs())); // [--url=devdb, --username=dev_user, --password=dev_pw, mode=on]
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); // [mode=on]
        log.info("OptionNames = {}", appArgs.getOptionNames()); // [password, url, username]
        Set<String> optionNames = appArgs.getOptionNames();

        for (String optionName : optionNames) {
            // password=[dev_pw] url=[devdb] username=[dev_user]
            log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
        }
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode");

        log.info("url={}", url); // [devdb]
        log.info("username={}", username); // [dev_user]
        log.info("password={}", password); // [dev_pw]
        log.info("mode={}", mode); // null
    }
}