package com.lsytest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.lsytest"})
@ImportResource(locations = {"classpath:spring-lsy-project-demo.xml"})
@PropertySource("system.properties")
public class LsyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyDemoApplication.class, args);
    }
}
