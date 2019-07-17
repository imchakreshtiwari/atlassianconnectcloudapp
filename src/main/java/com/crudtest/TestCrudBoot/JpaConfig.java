package com.crudtest.TestCrudBoot;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.crudtest.TestCrudBoot.repository")
@EnableTransactionManagement
public class JpaConfig { }