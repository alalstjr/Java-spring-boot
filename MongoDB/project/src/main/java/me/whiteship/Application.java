package me.whiteship;

import me.whiteship.account.Account;
import me.whiteship.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class Application {

//    @Autowired
//    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

//    mongoTemplate 사용방법
/*    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setUsername("jjunpro");
            account.setEmail("jjunpro@git.com");

            mongoTemplate.insert(account);

            System.out.println("insert ok!");
        };
    }*/

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setUsername("jjunpro");
            account.setEmail("jjunpro@git.com");

            accountRepository.insert(account);
        };
    }
}
