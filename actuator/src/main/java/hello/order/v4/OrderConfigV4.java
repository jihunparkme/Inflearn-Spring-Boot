package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV4 {
    @Bean
    OrderService orderService() {
        return new OrderServiceV4();
    }

    /**
     * TimedAspect 를 적용해야 @Timed AOP 적용
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}