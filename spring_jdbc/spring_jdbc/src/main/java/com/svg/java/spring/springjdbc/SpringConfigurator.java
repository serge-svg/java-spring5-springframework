package com.svg.java.spring.springjdbc;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.svg.java.spring.springjdbc")
public class SpringConfigurator {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); 
        dataSource.setUrl("jdbc:postgresql://localhost/spring_course");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");

        return dataSource;
    }
    
}
