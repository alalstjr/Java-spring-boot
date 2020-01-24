package me.whiteship.memospringmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**") // mobile 이라는 요청이 들어 온다면
                .addResourceLocations("classpath:/mobile/")     // classpath:map 디렉토리 밑에서 제공을 하겠다.
                .setCachePeriod(20);                            // 만드시 classpath는 / 으로 끝나야 합니다.
    }
}
