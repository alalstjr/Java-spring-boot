package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

//    @Value("${jjunpro.name}")
//    private String name;
//
//    @Value("${jjunpro.age}")
//    private String age;
//
//    @Autowired
//    Environment environment;

    @Autowired
    JjunproProperties jjunproProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(jjunproProperties.getName());
        System.out.println(jjunproProperties.getAge());
        System.out.println(jjunproProperties.getFullName());
        System.out.println("=============");
    }
}
