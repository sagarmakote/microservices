package org.makote.revieweurekaclient2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewEurekaClient2Application {
    @Value("${spring.application.name}")
    private String ApplicationName;
    public static void main(String[] args) {
        SpringApplication.run(ReviewEurekaClient2Application.class, args);
    }



}