package com.gd.demo.service;


import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.repository.SentencesRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Setter
@Service
public class SentencesServiceImpl implements SentencesService {

    @Autowired
    SentencesRepository userRepository;


    private List<Word> noums;
    private List<Word> verbs;
    private List<Word> adjectives;

    List<Sentence> sent;
    Random random = new Random();

    @Override
    public List<Word> getAllWords() {
        return userRepository.findAll();
    }

    public List<Sentence> generateSentence() {
        List<Word> words = getAllWords();

        List<Word> noums = ExtractWordsByCategory(words, WordCategory.NOUN);
        List<Word> verbs = ExtractWordsByCategory(words,WordCategory.VERB);
        List<Word> adjectives = ExtractWordsByCategory(words, WordCategory.ADJECTIVE);

        sent = new ArrayList<>();

        for(int i=0;i<8;i++) {
            Sentence sentence = new Sentence();
            sentence.setId(new Long(i));
            sentence.setSentence(
                    noums.get(getRandomNumberBetwwenWordListIndex(noums.size()-1)).getWord() + " " +
                    verbs.get(getRandomNumberBetwwenWordListIndex(verbs.size()-1)).getWord() + " " +
                    adjectives.get(getRandomNumberBetwwenWordListIndex(adjectives.size()-1)).getWord()
            );
            sent.add(sentence);

        }

        return sent;
    }

    private int getRandomNumberBetwwenWordListIndex(Integer numberOfFields) {
        return random.nextInt(numberOfFields);
    }

    private List<Word> ExtractWordsByCategory(List<Word> words, WordCategory category) {
        return words.stream()
                .filter(w -> w.getCategory().toString().equals(category.toString()))
                .collect(Collectors.toList());
    }



}
