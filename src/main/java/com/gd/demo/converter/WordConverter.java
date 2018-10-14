package com.gd.demo.converter;

import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WordConverter {


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "category", target = "category")
    })

    Word toEntity(WordDto dtoList);

    WordDto toDto(Word entityList);

}
