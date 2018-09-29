package com.gd.demo;

import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSentencesApplication {


    @Autowired
    SentencesRepository sentencesRepository;

    public static void main(String[] args) {

        SpringApplication.run(AppSentencesApplication.class, args);
    }
}
