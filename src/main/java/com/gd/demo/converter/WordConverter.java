package com.gd.demo.converter;

import com.gd.demo.domain.Word;
import com.gd.demo.dto.WordDto;
import lombok.Getter;
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

    public abstract Word toEntity(WordDto dtoList);

    public abstract WordDto toDto(Word entityList);

}
