package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.ICharactersToCharacterDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageCharactersToCharacterContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.dto.CharacterContainerWrapperDto;
import br.com.urbainski.api.marvel.dto.CharacterDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageCharactersToCharacterContainerWrapperDtoConverterImpl implements
        IPageCharactersToCharacterContainerWrapperDtoConverter {

    private final @NonNull ICharactersToCharacterDtoConverter charactersToCharacterDtoConverter;

    @Override
    public CharacterContainerWrapperDto convert(Page<Characters> value) {

        List<CharacterDto> listCharacterDto = new ArrayList<>();

        value.getContent().forEach(
                characters -> listCharacterDto.add(charactersToCharacterDtoConverter.convert(characters)));

        return CharacterContainerWrapperDto.builder()
                .offset(value.getPageable().getOffset())
                .limit(value.getPageable().getPageSize())
                .count(value.getContent().size())
                .total(value.getTotalElements())
                .results(listCharacterDto)
                .build();
    }

}