package com.gd.demo.service;


import com.gd.demo.converter.EntityConverter;
import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.SentenceDto;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SentencesServiceImpl implements SentencesService {

    @Autowired
    SentencesRepository userRepository;

    @Autowired
    Sentence sentences;



    private List<Word> noums;
    private List<Word> verbs;
    private List<Word> adjectives;

    private List<String> sentencesShow = new ArrayList<>();

    @Override
    public List<Word> getAllWords() {
        return userRepository.findAll();
    }

    public List<Sentence> generateSentence() {
        List<Word> words = getAllWords();

        List<Word> noums = ExtractWordsByCategory(words, WordCategory.NOUN);
        List<Word> verbs = ExtractWordsByCategory(words,WordCategory.VERB);
        List<Word> adjectives = ExtractWordsByCategory(words, WordCategory.ADJECTIVE);

        List<Sentence> sent = new ArrayList<>();


        Random random = new Random();

        for(int i=0;i<3;i++) {
            sentences.setSentence(
                    noums.get(getRandomNumberBetwwenWordListIndex(noums, random)).getWord() + " " +
                    verbs.get(getRandomNumberBetwwenWordListIndex(verbs, random)).getWord() + " " +
                    adjectives.get(getRandomNumberBetwwenWordListIndex(adjectives, random)).getWord()
            );
            sent.add(sentences);

        }

        return sent;
    }

    private int getRandomNumberBetwwenWordListIndex(List<Word> noums, Random random) {
        return random.nextInt(noums.size()-1);
    }

    private List<Word> ExtractWordsByCategory(List<Word> words, WordCategory category) {
        return words.stream()
                .filter(w -> w.getCategory().toString().equals(category.toString()))
                .collect(Collectors.toList());
    }



}
