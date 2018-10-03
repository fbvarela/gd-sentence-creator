package com.gd.demo.service;

import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;

import java.util.List;

public interface SentencesService {
    public List<Word> getAllWords();

    public List<Sentence> generateSentence();
}
