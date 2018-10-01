package com.gd.demo.service;


import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentencesServiceImpl implements SentencesService {

    @Autowired
    SentencesRepository userRepository;

    @Override
    public List<Word> getAllWords() {
        return userRepository.findAll();
    }

    public String generateSentence(){
        List<Word> words = getAllWords();

        return words.toString();
    }


}
