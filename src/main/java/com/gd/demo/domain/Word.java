
package com.gd.demo.domain;


import com.gd.demo.enums.WordCategory;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Builder
@Entity
@Table(name = "WORDS")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "word")
    private String word;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private WordCategory category;




}