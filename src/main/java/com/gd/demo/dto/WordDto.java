package com.gd.demo.dto;

public class WordDto {

    private Long wordId;

    private String word;

    private String category;



    public WordDto(Long wordId, String word) {
        this.wordId = wordId;
        this.word = word;
        this.category = category;
    }

    public WordDto() {}

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
