package com.gd.demo.controller;


import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.service.SentencesServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Word"),
        @ApiResponse(code = 204, message = "No words have been retrieved", response = Error.class) })
    @GetMapping(value = "/words")
    public List<Word> getAllWords() {
        List<Word> result = sentencesServiceImpl.getAllWords();
        return result;
    }


    // POST /sentences/generate

    @ApiOperation(value = "Create sentences ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Word"),
            @ApiResponse(code = 204, message = "No words have been retrieved", response = Error.class) })
    @GetMapping(value = "/sentences/generate")
    public String generateSentence() {
        String result = sentencesServiceImpl.generateSentence();

        return result;
    }
}
