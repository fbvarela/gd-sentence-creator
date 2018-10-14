package com.gd.demo.service;

import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.repository.SentenceRepository;
import com.gd.demo.repository.WordRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceServiceImplTest {

    SentenceServiceImpl sentenceService;

    SentenceRepository sentenceRepository;

    WordRepository wordRepository;

    @Before
    public void setUp() throws Exception {
        this.sentenceService = new SentenceServiceImpl();
        MockitoAnnotations.initMocks(this);

        sentenceRepository = Mockito.mock(SentenceRepository.class);
        sentenceService.setSentenceRepository(sentenceRepository);

        wordRepository = Mockito.mock(WordRepository.class);
        sentenceService.setWordRepository(wordRepository);
    }

    private Word createWord(String word, WordCategory category) {
        return new Word().builder().name(word).category(category).build();
    }

    private Sentence createSentence() {
        return new Sentence().builder().text("Dogs are good").build();
    }

    @Test
    public void findByWord() {


    }

    @Test
    public void getAllWords() {

    }

    @Test
    public void generateSentence() {
        Mockito.when(wordRepository.findAll()).thenReturn(Arrays
                .asList(createWord("He", WordCategory.NOUN),
                        createWord("is", WordCategory.VERB),
                        createWord("good", WordCategory.ADJECTIVE),
                        createWord("Dogs", WordCategory.NOUN),
                        createWord("are", WordCategory.VERB),
                        createWord("fine", WordCategory.ADJECTIVE),
                        createWord("It", WordCategory.NOUN),
                        createWord("is", WordCategory.VERB),
                        createWord("big", WordCategory.ADJECTIVE)
                        ));

        Mockito.when(this.sentenceRepository.save(createSentence())).thenReturn(createSentence());

        this.sentenceService.setWordRepository(this.wordRepository);
        this.sentenceService.setSentenceRepository(this.sentenceRepository);

        List<Sentence> sentences = sentenceService.generateSentence();

        assertEquals(8, sentences.size());

        List<String> wordList = Arrays.asList(sentences.get(0).getText().split(" "));

        assertEquals(3, wordList.size());




    }

    @Test
    public void save() {
    }

    @Test
    public void getAllSentences() {
    }

    @Test
    public void getSentenceById() {
    }
}