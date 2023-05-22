package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {

    /**
     * 윈도우 OS: set
     * MAC, 리눅스 OS: printenv
     */
    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv(); // 전체 OS 환경 변수를 Map 으로 조회
        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, System.getenv(key)); // 특정 OS 환경 변수의 값을 String 으로 조회
        }
    }
}