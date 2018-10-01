package com.gd.demo.service;

import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;

import java.util.List;

public interface SentencesService {
    public List<Word> getAllWords();
}
