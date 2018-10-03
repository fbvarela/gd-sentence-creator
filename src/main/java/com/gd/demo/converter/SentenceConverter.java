package com.gd.demo.converter;

import com.gd.demo.domain.Sentence;
import com.gd.demo.dto.SentenceDto;
import lombok.Getter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Getter
@Component
@Mapper(componentModel = "spring")
public abstract class SentenceConverter {

    public abstract Sentence toEntity(SentenceDto dtoList);

    public abstract SentenceDto toDto(Sentence entityList);

}

