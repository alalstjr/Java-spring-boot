package me.whiteship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(H2Runner.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            // 접속할 DB의 정보 URL 정보와
            String url = connection
                    .getMetaData()
                    .getURL();
            // user 정보를 확인할 수 있습니다.
            String username = connection
                    .getMetaData()
                    .getUserName();

            logger.info(url + "<:>" + username);

            Statement statement = connection.createStatement();
            String    sql       = "CREATE TABLE TEST(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }

        // jdbcTemplate 사용
        // jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'jjunprop')");
    }
}
