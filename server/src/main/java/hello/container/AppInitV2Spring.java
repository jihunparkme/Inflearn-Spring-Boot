package hello.container;

import hello.spring.HelloConfig;
import
        org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

/**
 * http://localhost:8080/spring/hello-spring
 *
 * AppInit 구현을 하였으므로 애플리케이션 초기화 코드가 자동으로 실행
 * MyContainerInitV2 에 @HandlesTypes(AppInit.class) 선언이 되어있기 때문
 */
public class AppInitV2Spring implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // 스프링 컨테이너 생성 (애노테이션 기반 설정과 웹 기능을 지원하는 스프링 컨테이너)
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        // 컨테이너에 스프링 설정 추가
        appContext.register(HelloConfig.class);

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcher = new DispatcherServlet(appContext);

        // 디스패처 서블릿을 서블릿 컨테이너에 등록 (이름 주의! dispatcherV2)
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcher);

        // /spring/* 요청이 디스패처 서블릿을 통하도록 설정
        servlet.addMapping("/spring/*");
    }
}
