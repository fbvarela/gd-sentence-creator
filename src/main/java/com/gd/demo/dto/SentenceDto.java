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
public class SentenceDto {

    private String sentence;

}
