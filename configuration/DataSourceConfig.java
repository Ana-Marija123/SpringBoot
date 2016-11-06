package com.example.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.activation.DataSource;


@Configuration
public class DataSourceConfig {

//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/myitems");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        return dataSourceBuilder.build();
//    }

}
