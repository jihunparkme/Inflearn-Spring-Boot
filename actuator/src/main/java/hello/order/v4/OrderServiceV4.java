package hello.order.v4;

import hello.order.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Timed
 * 타입이나 메서드 중에 적용 가능
 * 타입에 적용 시 해당 타입의 모든 public 메서드에 타이머가 적용
 */
@Timed("my.order")
@Slf4j
public class OrderServiceV4 implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();
        sleep(500);
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();
        sleep(200);
    }

    private static void sleep(int l) {
        try {
            Thread.sleep(l + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}