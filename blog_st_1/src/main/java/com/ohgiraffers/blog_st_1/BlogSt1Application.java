package com.ohgiraffers.blog_st_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogSt1Application {

    public static void main(String[] args) {
        SpringApplication.run(BlogSt1Application.class, args);
    }

}
