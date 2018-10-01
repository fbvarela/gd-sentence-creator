package com.gd.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "WORDS")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "word", unique = true)
    private String word;

    @NotEmpty
    @Column(name = "category", unique = true)
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return category;
    }

    public void setType(String type) {
        this.category = type;
    }

    public Word(@NotEmpty String word, @NotEmpty String type) {
        this.word = word;
        this.category = type;
    }

    public Word() { }
}
