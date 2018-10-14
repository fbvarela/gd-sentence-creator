package com.gd.demo.converter;

import com.gd.demo.domain.Sentence;
import com.gd.demo.dto.SentenceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface  SentenceConverter {

    @Mapping(source = "text", target = "text")

    Sentence toEntity(SentenceDto dtoList);

    SentenceDto toDto(Sentence entityList);

}

