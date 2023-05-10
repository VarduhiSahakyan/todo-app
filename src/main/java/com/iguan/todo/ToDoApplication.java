package com.iguan.todo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class ToDoApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String... args) {
        SpringApplication.run(ToDoApplication.class, args);

    }
}