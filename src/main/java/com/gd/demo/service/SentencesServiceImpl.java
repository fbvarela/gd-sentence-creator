package com.gd.demo.service;


import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentencesServiceImpl implements SentencesService {

    @Autowired
    SentencesRepository userRepository;

    @Override
    public List<Word> getAllWords() {
        return userRepository.findAll();
    }

    public String generateSentence() {
        List<Word> words = getAllWords();

        List<Word> noums = ExtractWordsByCategory(words, WordCategory.NOUN.toString());
        List<Word> verbs = ExtractWordsByCategory(words, WordCategory.VERB.toString());
        List<Word> adjectives = ExtractWordsByCategory(words, WordCategory.ADJECTIVE.toString());


        return words.toString();
    }

    private List<Word> ExtractWordsByCategory(List<Word> words, String category) {
        List<Word> noums = words.stream()
                .filter(w -> w.getCategory().equals(category))
                .collect(Collectors.toList());
        return noums;
    }


}
