package com.crudtest.TestCrudBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class AddonApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(AddonApplication.class).run(args);
    }
}
