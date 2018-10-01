package com.gd.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SENTENCE")
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "sentence")
    private String sentence;

    @Override
    public String toString() {
        return "Created sentence: " + sentence;
    }
}
