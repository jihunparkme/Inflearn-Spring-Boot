package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringBootApplication;

/**
 * 컴포넌트 스캔이 추가되어 있는 @MySpringBootApplication
 * 컴포넌트 스캔의 기본 동작은 해당 애노테이션이 붙은 클래스의 현재 패키지 부터 그 하위 패키지를 컴포넌트 스캔의 대상으로 사용
 */
@MySpringBootApplication
public class MySpringBootMain {
    public static void main(String[] args) {
        System.out.println("MySpringBootMain.main");
        // 내장 톰캣 실행, 스프링 컨테이너 생성, 디스패처 서블릿, 컴포넌트 스캔까지 모든 기능이 한번에 동작
        MySpringApplication.run(MySpringBootMain.class, args);
    }
}
