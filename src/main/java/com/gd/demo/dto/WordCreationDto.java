package com.gd.demo.dto;

import com.gd.demo.domain.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

public class WordCreationDto {
    private List<Word> words;

    public void addWord(Word word) {
        this.words.add(word);
    }

}
