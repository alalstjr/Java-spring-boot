package me.whiteship;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        // PORT 정보를 알아내는 방법
        // Web Application Context 정보를 가져옵니다.
        ServletWebServerApplicationContext context = event.getApplicationContext();
        int                                result  = context.getWebServer().getPort();

        System.out.println(result);
    }
}
