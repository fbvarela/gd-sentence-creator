package com.gd.demo.controller;


import com.gd.demo.converter.SentenceConverter;
import com.gd.demo.converter.WordConverter;
import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.SentenceDto;
import com.gd.demo.dto.WordDto;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.exceptions.SentenceNotFoundException;
import com.gd.demo.exceptions.WordNotFoundException;
import com.gd.demo.service.SentenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Operations pertaining to Sentences Generator")
@RestController
@Setter
public class SentenceController {

    @Autowired
    private SentenceConverter sentenceConverter;

    @Autowired
    private WordConverter wordConverter;

    @Autowired
    private SentenceService sentencesService;


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

    @ApiOperation(value = "Generate sentences")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Sentence"),
        @ApiResponse(code = 204, message = "No Sentences have been retrieved", response = SentenceNotFoundException.class) })
    @GetMapping(value = "/sentences/generate")
    public ResponseEntity<List<SentenceDto>> generateSentence() {
        List<Sentence> sentences = sentencesService.generateSentence();

        if (sentences == null || sentences.isEmpty()) {
            throw new SentenceNotFoundException("No Sentences found.");
        }
        List<SentenceDto> result = sentences.stream().map(sentenceConverter::toDto).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // POST /home

    @ApiOperation(value = "Save words")
    @PostMapping(value = "/home")
    @ApiResponse(code = 201, message = "Word saved", response = Error.class)
    public void saveWord(HttpServletResponse response, @Valid @RequestParam("name") String name, @Valid @RequestParam("category") String category) throws URISyntaxException, IOException {

        Word word = sentencesService.save(Word.builder().name(name).category(WordCategory.valueOf(category)).build());

        response.sendRedirect("/home");
    }


    // GET /words/{word}

    @ApiOperation(value = "View a word")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Word"),
            @ApiResponse(code = 204, message = "No Words have been retrieved", response = WordNotFoundException.class) })
    @GetMapping(value = "/words/{word}",
                produces="application/json")

    public ResponseEntity<WordDto> getWord(@Valid @PathVariable String word) {
          Word wordResponse = sentencesService.getWord(word);
          if (wordResponse == null) {
              throw new WordNotFoundException("No word found: " + word);
          }

          WordDto wordDto = wordConverter.toDto(wordResponse);

          return new ResponseEntity<>(wordDto, HttpStatus.OK);
      }

    // GET /sentences

    @ApiOperation(value = "View sentences")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Sentence"),
        @ApiResponse(code = 204, message = "No Sentences have been retrieved",
                    response = SentenceNotFoundException.class) })
    @GetMapping(value = "/sentences",
            produces="application/json")

    public ResponseEntity<List<SentenceDto>> getSentences() {
        List<Sentence> sentencesResponse = sentencesService.getAllSentences();

        if (sentencesResponse.isEmpty() || sentencesResponse == null) {
            throw new SentenceNotFoundException("No Sentences found");
        }

        List<SentenceDto> result = sentencesResponse.stream().map(sentenceConverter::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

   // GET /sentences/{sentenceID}

    @ApiOperation(value = "View sentences")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retrieve at least one Sentence"),
        @ApiResponse(code = 204, message = "No Sentence has been retrieved",
                    response = SentenceNotFoundException.class) })
   @GetMapping(value = "/sentences/{sentenceId}",
           produces="application/json")
   public ResponseEntity<SentenceDto> getSentence(@Valid @PathVariable Long sentenceId) {

        Sentence sentenceResponse = sentencesService.getSentenceById(sentenceId);

        if (sentenceResponse == null) {
           throw new WordNotFoundException("No Sentences found");
       }
        SentenceDto result = sentenceConverter.toDto(sentenceResponse);

        return new ResponseEntity<>(result, HttpStatus.OK);
   }
}