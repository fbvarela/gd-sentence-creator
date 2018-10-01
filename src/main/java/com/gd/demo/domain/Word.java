
package com.gd.demo.domain;


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
    //@Enumerated(EnumType.ORDINAL)
    private String category;

    //@Column(name = "weight")
    //private double weight = 1;


}