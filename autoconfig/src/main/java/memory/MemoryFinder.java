package memory;

import lombok.extern.slf4j.Slf4j;
import jakarta.annotation.PostConstruct;

@Slf4j
public class MemoryFinder {

    /**
     * JVM에서 메모리 정보를 실시간으로 조회하는 기능
     */
    public Memory get() {
        long max = Runtime.getRuntime().maxMemory(); // JVM이 사용할 수 있는 최대 메모리 (이 수치를 넘어가면 OOM 발생)
        long total = Runtime.getRuntime().totalMemory(); // JVM이 확보한 전체 메모리(JVM은 처음부터 max 까지 다 확보하지 않고 필요할 때 마다 조금씩 확보)
        long free = Runtime.getRuntime().freeMemory(); // total 중에 사용하지 않은 메모리(JVM이 확보한 전체 메모리 중에 사용하지 않은 것)
        long used = total - free; // JVM이 사용중인 메모리
        return new Memory(used, max);
    }

    @PostConstruct
    public void init() {
        log.info("init memoryFinder");
    }
}
