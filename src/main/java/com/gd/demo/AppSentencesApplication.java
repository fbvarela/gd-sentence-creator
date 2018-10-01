package com.gd.demo;

import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
public class AppSentencesApplication {


    public static void main(String[] args) {

        SpringApplication.run(AppSentencesApplication.class, args);
    }
}
