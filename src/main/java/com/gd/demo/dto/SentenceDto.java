package com.gd.demo.dto;

import com.gd.demo.domain.Word;
import lombok.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

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
