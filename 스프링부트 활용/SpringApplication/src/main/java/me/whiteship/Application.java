package me.whiteship;

import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //        기존 Spring Boot 실행 코드
        //        SpringApplication.run(Application.class, args);

        //        변경 후 Spring Boot 실행 코드
        //        SpringApplication app = new SpringApplication(Application.class);
        //        app.run(args);

        //        배너를 커스텀하기
        //        app.setBanner((environment, sourceClass, out) -> {
        //            out.println("===========");
        //            out.println("Edit Banner");
        //            out.println("===========");
        //        });

        //        배너를 사용하지 않기
        //        app.setBannerMode(Banner.Mode.OFF);

        //        SpringApplicationBuilder로 빌더 패턴 사용 가능
        new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);
    }
}