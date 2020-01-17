package me.whiteship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //    HTTP & HTTPS 둘다 적용하는 코드
    //    @Bean
    //    public ServletWebServerFactory servletContainer() {
    //        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
    //        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
    //        return tomcat;
    //    }
    //
    //    private Connector createStandardConnector() {
    //        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    //        connector.setPort(8080);
    //        return connector;
    //    }
}
