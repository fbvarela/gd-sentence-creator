package com.gd.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Builder
@ToString
@Component
public class WordDto {

    private String word;

    private String category;

}
