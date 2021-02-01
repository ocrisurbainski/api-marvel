package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.dto.CharacterContainerWrapperDto;

public interface IPageCharactersToCharacterContainerWrapperDtoConverter extends
        IDefaultConverter<Page<Characters>, CharacterContainerWrapperDto> {

}