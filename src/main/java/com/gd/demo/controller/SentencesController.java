package com.gd.demo.controller;


import com.gd.demo.domain.Word;
import com.gd.demo.service.SentencesServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SentencesController {


    @Autowired
    private SentencesServiceImpl sentencesServiceImpl;



    // GET /words

    @ApiOperation(value = "Retrieve all words")
    @GetMapping(value = "/words")
    public List<Word> getAllWords() {
        List<Word> result = sentencesServiceImpl.getAllWords();
        return result;
    }

}
