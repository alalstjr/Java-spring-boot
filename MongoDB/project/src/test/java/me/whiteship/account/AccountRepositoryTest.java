package me.whiteship.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest  // mongo 관련된 bean 등만 등록이 됩니다.
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setEmail("jjunpro@git.com");
        account.setUsername("jjunpro");

        accountRepository.save(account);

        Optional<Account> resultId = accountRepository.findById(account.getId());
        assertThat(resultId).isNotEmpty();
    }
}