package org.makote.genereeurekaclient3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class GenreEurekaClient3Application {
    @Value("${spring.application.name}")
    private String ApplicationName;
    public static void main(String[] args) {
        SpringApplication.run(GenreEurekaClient3Application.class, args);
    }


}