package com.gd.demo.controller;

import com.gd.demo.dto.WordDto;
import com.gd.demo.service.SentencesService;
import com.gd.demo.service.SentencesServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SentencesController {

    @Autowired
    SentencesServiceImpl sentencesServiceImpl;

    // GET /words

    @ApiOperation(value = "Retrieve all words")

    public List<WordDto> getUserById(@PathVariable Integer userId) {
        return sentencesServiceImpl.getAllWords();
    }

}
