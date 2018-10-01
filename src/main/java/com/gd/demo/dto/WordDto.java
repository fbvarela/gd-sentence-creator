package com.gd.demo.dto;

public class WordDto {

    private Long id;

    private String word;

    private String category;



    public WordDto(Long wordId, String word) {
        this.id = wordId;
        this.word = word;
        this.category = category;
    }

    public WordDto() {}

    public Long getWordId() {
        return id;
    }

    public void setWordId(Long wordId) {
        this.id = wordId;
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
