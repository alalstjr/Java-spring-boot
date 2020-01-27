package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("jjunpro", "whiteship");
        operations.set("springboot", "2.0");

        Account account = new Account();
        account.setEmail("jjunpro@git.com");
        account.setUsername("jjunpro");

        accountRepository.save(account);

        Optional<Account> result = accountRepository.findById(account.getId());
        System.out.println(result.get().getId());
        System.out.println(result.get().getEmail());
        System.out.println(result.get().getUsername() );
    }
}
