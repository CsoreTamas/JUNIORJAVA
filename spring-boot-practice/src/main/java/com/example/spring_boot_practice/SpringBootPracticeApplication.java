package com.example.spring_boot_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
// Tells Spring to automatically handle paging in web requests and covert
// the data to DTOs before sending it, so you don't expose your raw entities
// (There as a warring in the console)
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class SpringBootPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticeApplication.class, args);
    }
}
