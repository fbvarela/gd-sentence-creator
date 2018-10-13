package com.gd.demo.service;


import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.enums.WordCategory;
import com.gd.demo.repository.SentenceRepository;
import com.gd.demo.repository.WordRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Setter
@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    SentenceRepository sentenceRepository;

    @Autowired
    WordRepository wordRepository;


    private List<Word> noums;
    private List<Word> verbs;
    private List<Word> adjectives;

    List<Sentence> sentences;
    Random random = new Random();

    @Override
    public Word findByWord(String word) {
        return wordRepository.findByName(word);
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public List<Sentence> generateSentence() {
        List<Word> words = getAllWords();

        List<Word> noums = ExtractWordsByCategory(words, WordCategory.NOUN);
        List<Word> verbs = ExtractWordsByCategory(words,WordCategory.VERB);
        List<Word> adjectives = ExtractWordsByCategory(words, WordCategory.ADJECTIVE);

        sentences = new ArrayList<>();

        for(int i=0;i<8;i++) {
            Sentence sentence = new Sentence();
            sentence.setId(new Long(i));
            sentence.setSentence(
                    noums.get(getRandomNumberUpToTheListSize(noums.size()-1)).getName() + " " +
                    verbs.get(getRandomNumberUpToTheListSize(verbs.size()-1)).getName() + " " +
                    adjectives.get(getRandomNumberUpToTheListSize(adjectives.size()-1)).getName()
            );
            sentences.add(sentence);
        }

        if (!sentences.isEmpty()) {
            saveSentences(sentences);
        }

        return sentences;
    }

    private void saveSentences (List<Sentence> sentences) {

        sentences.forEach((sentence) -> sentenceRepository.save(sentence));
    }

    @Override
    public Word save(Word word) {
        Word wordSaved = Word.builder().name("").category(null).build();
        if (!word.getName().isEmpty() || word.getCategory().toString() != null) {
            wordSaved = wordRepository.save(word);
        }
        return wordSaved;
    }

    private int getRandomNumberUpToTheListSize(Integer numberOfFields) {

        return random.nextInt(numberOfFields);
    }

    private List<Word> ExtractWordsByCategory(List<Word> words, WordCategory category) {
        return words.stream()
                .filter(w -> w.getCategory().toString().equals(category.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Sentence> getAllSentences() {
        return sentenceRepository.findAll();
    }

}
