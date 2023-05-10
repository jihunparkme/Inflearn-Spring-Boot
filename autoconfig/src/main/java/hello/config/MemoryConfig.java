package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * MemoryCondition matches() 실행
 * 결과가 true 일 경우
 * MemoryConfig 는 정상 동작 -> memoryController, memoryFinder 빈 등록
 *
 * 결과가 false 일 경우
 * MemoryConfig 는 무효화 -> memoryController, memoryFinder 빈은 등록되지 않음
 */
@Configuration
@Conditional(MemoryCondition.class)
public class MemoryConfig {
    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
