package com.gd.demo.converter;

import com.gd.demo.domain.Sentence;
import com.gd.demo.dto.SentenceDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EntityConverter {


    public List<Sentence> toEntity(List<SentenceDto> dtoList);

    public List <SentenceDto> toDto(List<Sentence> entityList);


}
