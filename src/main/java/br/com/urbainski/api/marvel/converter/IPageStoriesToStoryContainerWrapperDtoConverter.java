package br.com.urbainski.api.marvel.converter;

import org.springframework.data.domain.Page;

import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.dto.StoryContainerWrapperDto;

public interface IPageStoriesToStoryContainerWrapperDtoConverter extends
        IDefaultConverter<Page<Stories>, StoryContainerWrapperDto> {

}