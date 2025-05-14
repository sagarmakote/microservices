package org.makote.movieeurekaclient1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
public class MovieEurekaClient1Application {
    @Value("${spring.application.name}")
    private String ApplicationName;
    public static void main(String[] args) {

        System.out.println("inside MovieEurekaClient1Application");
        SpringApplication.run(MovieEurekaClient1Application.class, args);
    }


}
