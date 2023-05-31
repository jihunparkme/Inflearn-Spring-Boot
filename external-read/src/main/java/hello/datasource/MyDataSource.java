package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class MyDataSource {
    private String url;
    private String username;
    private String password;
    private int maxConnection;
    private Duration timeout;
    private List<String> options;

    public MyDataSource(String url, String username, String password, int
            maxConnection, Duration timeout, List<String> options) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnection = maxConnection;
        this.timeout = timeout;
        this.options = options;
    }

    @PostConstruct
    public void init() {
        log.info("url={}", url); // url=local.db.com
        log.info("username={}", username); // username=local_user
        log.info("password={}", password); // password=local_pw
        log.info("maxConnection={}", maxConnection); // maxConnection=1
        log.info("timeout={}", timeout); // timeout=PT3.5S
        log.info("options={}", options); // options=[CACHE, ADMIN]
    }
}