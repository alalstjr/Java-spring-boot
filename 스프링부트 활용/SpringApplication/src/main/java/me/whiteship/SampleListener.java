package me.whiteship;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 이벤트 리스너 사용 예제 클래스
// public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {
//
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent event) {
//        System.out.println("=========");
//        System.out.println("App ApplicationStartingEvent");
//        System.out.println("=========");
//    }
// }

// ApplicationArguments 사용 예제 클래스
// @Component
// public class SampleListener {
//    public SampleListener(ApplicationArguments arguments) {
//        System.out.println("foo: " + arguments.containsOption("foo"));
//        System.out.println("bar: " + arguments.containsOption("bar"));
//    }
// }

// ApplicationRunner 사용 예제
// @Component
// public class SampleListener implements ApplicationRunner {
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("foo: " + args.containsOption("foo"));
//        System.out.println("bar: " + args.containsOption("bar"));
//    }
// }

// CommandLineRunner 사용 예제
@Component
public class SampleListener implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(System.out::println);
    }
}