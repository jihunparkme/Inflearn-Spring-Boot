package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(AppInit.class) // 애플리케이션 초기화 인터페이스(AppInit.class) 지정
public class MyContainerInitV2 implements ServletContainerInitializer {

    /**
     * @param c : 애플리케이션 초기화 인터페이스(AppInit.class )의 구현체들(AppInitV1Servlet.class)을 모두 찾아서 클래스 정보로 전달
     * @param ctx
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("MyContainerInitV2 c = " + c);
        System.out.println("MyContainerInitV2 container = " + ctx);

        for (Class<?> appInitClass : c) {
            try {
                // 리플렉션을 사용한 객체 생성 => new AppInitV1Servlet()과 같은 코드
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                // 애플리케이션 초기화 코드를 직접 실행하면서 서블릿 컨테이너 정보가 담긴 ctx 도 함께 전달
                appInit.onStartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}