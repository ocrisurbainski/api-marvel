package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IPageStoriesToStoryContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IStoriesToStoryDtoConverter;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.dto.StoryContainerWrapperDto;
import br.com.urbainski.api.marvel.dto.StoryDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageStoriesToStoryContainerWrapperDtoConverterImpl implements
        IPageStoriesToStoryContainerWrapperDtoConverter {

    private final @NonNull IStoriesToStoryDtoConverter storiesToStoryDtoConverter;

    @Override
    public StoryContainerWrapperDto convert(Page<Stories> value) {

        List<StoryDto> listStoryDto = new ArrayList<>();

        value.getContent().forEach(
                stories -> listStoryDto.add(storiesToStoryDtoConverter.convert(stories)));

        return StoryContainerWrapperDto.builder()
                .offset(value.getPageable().getOffset())
                .limit(value.getPageable().getPageSize())
                .count(value.getContent().size())
                .total(value.getTotalElements())
                .results(listStoryDto)
                .build();
    }

}