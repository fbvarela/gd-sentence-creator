package com.gd.demo.converter;


import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

    @Component
    @Mapper(componentModel = "spring")
    public interface WordConverter {
        @Mappings({
            @Mapping(target = "id", source = "word.id"),
            @Mapping(target = "word", source = "word.word"),
            @Mapping(target = "type", source = "word.type")

        })

        WordDto toDTO(Word entity);

        @Mappings({
            @Mapping(target = "id", source = "dto.id"),
            @Mapping(target = "word", source = "dto.word"),
            @Mapping(target = "type", source = "dto.type")
        })

        Word toEntity(WordDto dto);

}