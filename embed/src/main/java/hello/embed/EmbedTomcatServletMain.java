package hello.embed;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class EmbedTomcatServletMain {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbedTomcatServletMain.main");

        /**
         * 톰캣 설정
         * 내장 톰캣을 생성하고, 톰캣이 제공하는 커넥터를 사용해서 8080 포트에 연결한다.
         */
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        /**
         * 서블릿 등록
         * 톰캣에 사용할 contextPath, docBase 지정
         * tomcat.addServlet() 을 통해 서블릿 등록
         * context.addServletMappingDecoded() 을 통해 등록한 서블릿의 경로 매핑
         */
        Context context = tomcat.addContext("", "/");
        tomcat.addServlet("", "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");
        tomcat.start();
    }
}
