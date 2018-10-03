package com.gd.demo.controller;

import com.gd.demo.converter.SentenceConverter;
import com.gd.demo.converter.WordConverter;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.exceptions.WordNotFoundException;
import com.gd.demo.service.SentencesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;

@RunWith(SpringJUnit4ClassRunner.class)

public class SentencesControllerTest {

    private SentencesController sentencesController;
    private SentencesService sentencesService;
    private WordConverter wordConverter;

    @Before
    public void init() {
        sentencesController = new SentencesController();

        MockitoAnnotations.initMocks(this);

        sentencesService = Mockito.mock(SentencesService.class);
        sentencesController.setSentencesService(sentencesService);

        wordConverter = Mockito.mock(WordConverter.class);
        Mockito.when(wordConverter.toDto(isA(Word.class))).thenReturn(
                createWordDto("He", "NOUN"));

        sentencesController.setWordConverter(wordConverter);
    }

    private WordDto createWordDto(String word, String category) {
        return new WordDto().builder().word(word).category(category).build();
    }

    private Word createWord(String word, WordCategory category) {
        return new Word().builder().word(word).category(category).build();
    }

    @Test
    public void getWordsTest_success()  {
        Mockito.when(sentencesService.getAllWords()).thenReturn(Arrays
                .asList(createWord("He", WordCategory.NOUN),
                        createWord("is", WordCategory.VERB),
                        createWord("good", WordCategory.ADJECTIVE)));

        sentencesController.setSentencesService(sentencesService);

        ResponseEntity<List<WordDto>> response = sentencesController.getAllWords();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().size());
    }

    @Test  (expected = WordNotFoundException.class)
    public void getWordsTest_fail()  {
        Mockito.when(sentencesService.getAllWords()).thenReturn(null);
        sentencesController.setSentencesService(sentencesService);
        sentencesController.getAllWords();
    }

        //TODO: a lot lot more unit test

}