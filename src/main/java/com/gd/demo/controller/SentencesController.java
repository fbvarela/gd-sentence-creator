package com.gd.demo.controller;


import com.gd.demo.converter.SentenceConverter;
import com.gd.demo.converter.WordConverter;
import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.SentenceDto;
import com.gd.demo.dto.WordDto;
import com.gd.demo.exceptions.SentenceNotFoundException;
import com.gd.demo.exceptions.WordNotFoundException;
import com.gd.demo.service.SentencesService;
import com.gd.demo.service.SentencesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Operations pertaining to Sentences Generator")
@RestController
@Setter
public class SentencesController {

    @Autowired
    private SentenceConverter sentenceConverter;

    @Autowired
    private WordConverter wordConverter;

    @Autowired
    private SentencesService sentencesService;


    // GET /words

    @ApiOperation(value = "Retrieve all words")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Word"),
        @ApiResponse(code = 204, message = "No words have been retrieved", response = Error.class) })
    @GetMapping(value = "/words")
    public ResponseEntity<List<WordDto>> getAllWords() {
        List<Word> words = sentencesService.getAllWords();

        if (words == null || words.isEmpty()) {
            throw new WordNotFoundException("No Words found.");
        }

        List<WordDto> result = words.stream().map(wordConverter::toDto).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /sentences/generate

    @ApiOperation(value = "Generate sentences ")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Sentence"),
            @ApiResponse(code = 204, message = "No Sentences have been retrieved", response = Error.class) })
    @GetMapping(value = "/sentences/generate")
    public ResponseEntity<List<SentenceDto>> generateSentence() {
        List<Sentence> sentences = sentencesService.generateSentence();

        if (sentences == null || sentences.isEmpty()) {
            throw new SentenceNotFoundException("No Sentences found.");
        }
        List<SentenceDto> result = sentences.stream().map(sentenceConverter::toDto).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //TODO: Rest of endpoints
}