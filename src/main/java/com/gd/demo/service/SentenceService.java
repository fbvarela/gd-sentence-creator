package com.gd.demo.service;

import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;

import java.util.List;

public interface SentenceService {

    Word getWord(String word);

    List<Word> getAllWords();

    List<Sentence> generateSentence();

    Word save(Word Word);

    List<Sentence> getAllSentences();

    Sentence getSentenceById(Long sentenceId);
}
