package com.xust.dto;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = {"com.xust.dao"}, sqlSessionFactoryRef = "mainSqlSessionFactory")
public class SiteDataConfig {
    @Bean
    DataSource mainDataSource(
            @Value("${mysql.main.datasource.driverClassName}") String driverClassName,
            @Value("${mysql.main.datasource.initializationFailTimeout}") long initializationFailTimeout,
            @Value("${mysql.main.datasource.idleTimeout}") long idleTimeout,
            @Value("${mysql.main.datasource.autoCommit}") boolean autoCommit,
            @Value("${mysql.main.datasource.connectionTimeout}") long connectionTimeout,
            @Value("${mysql.main.datasource.password}") String password,
            @Value("${mysql.main.datasource.username}") String username,
            @Value("${mysql.main.datasource.maxLifeTime}") long maxLifeTime,
            @Value("${mysql.main.datasource.minimumIdle}") int minimumIdle,
            @Value("${mysql.main.datasource.maximumPoolSize}") int maximumPoolSize,
            @Value("${mysql.main.datasource.jdbcUrl}") String jdbcUrl,
            @Value("${mysql.main.datasource.allowPoolSuspension}") boolean allowPoolSuspension,
            @Value("${mysql.main.datasource.readOnly}") boolean readOnly,
            @Value("${mysql.main.datasource.registerMbeans}") boolean registerMbeans,
            @Value("${mysql.main.datasource.isolationLevel}") String isolationLevel) throws IOException
    {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setConnectionTimeout(connectionTimeout);
        config.setIdleTimeout(idleTimeout);
        config.setAutoCommit(autoCommit);
        config.setMinimumIdle(minimumIdle);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMaxLifetime(maxLifeTime);
        config.setReadOnly(readOnly);
        config.setRegisterMbeans(registerMbeans);
        config.setDriverClassName(driverClassName);

        if (StringUtils.hasText(isolationLevel)) {
            config.setTransactionIsolation(isolationLevel);
        }

        return new HikariDataSource(config);
    }

    @Bean
    PlatformTransactionManager mainTransactionManager(@Qualifier("mainDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean
    SqlSessionFactoryBean mainSqlSessionFactory(@Qualifier("mainDataSource")DataSource dataSource){
        SqlSessionFactoryBean f = new SqlSessionFactoryBean();
        f.setDataSource(dataSource);
        return f;
    }

}
