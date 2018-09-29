package com.gd.demo.service;

import com.gd.demo.dto.WordDto;
import com.gd.demo.repository.SentencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentencesServiceImpl implements SentencesService {

    @Autowired
    SentencesRepository userRepository;

    @Override
    public List<WordDto> getAllWords() {
        return null;
    }
}
