package io.github.silver_the_dev.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(url);

        config.setMinimumIdle(1);
        config.setMaximumPoolSize(10);
        config.setPoolName("libray-db-pool");
        config.setMaxLifetime(600_000L);
        config.setConnectionTimeout(60_000L);
        config.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(config);
    }
}
