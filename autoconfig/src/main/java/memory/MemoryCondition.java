package memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class MemoryCondition implements Condition {
    /**
     * #java -Dmemory=on -jar project.jar
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String memory = context.getEnvironment().getProperty("memory"); // -Dmemory=on
        log.info("memory={}", memory);
        return "on".equals(memory);
    }
}