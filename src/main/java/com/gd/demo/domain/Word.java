
package com.gd.demo.domain;


import com.gd.demo.enums.WordCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table(name = "WORDS")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "word")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WordCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WordCategory getCategory() {
        return category;
    }

    public void setCategory(WordCategory category) {
        this.category = category;
    }
}