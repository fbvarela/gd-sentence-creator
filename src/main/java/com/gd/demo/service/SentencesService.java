package com.gd.demo.service;

import com.gd.demo.domain.Sentence;
import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;

import java.util.List;

public interface SentencesService {

    public Word findByWord(String word);

    public List<Word> getAllWords();

    public List<Sentence> generateSentence();

    public Word save(Word Word);
}
