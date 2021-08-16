package com.troy.rest_mysql_demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.troy.rest_mysql_demo.domain")
@EnableJpaRepositories("com.troy.rest_mysql_demo.repos")
@EnableTransactionManagement
public class DomainConfig {
}
