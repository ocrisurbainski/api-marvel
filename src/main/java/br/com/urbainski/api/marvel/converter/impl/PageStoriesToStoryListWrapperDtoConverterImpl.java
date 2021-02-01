package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IPageStoriesToStoryListWrapperDtoConverter;
import br.com.urbainski.api.marvel.converter.IStoriesToStoryDtoConverter;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.dto.StoryDto;
import br.com.urbainski.api.marvel.dto.StoryListWrapperDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageStoriesToStoryListWrapperDtoConverterImpl implements IPageStoriesToStoryListWrapperDtoConverter {

    private final @NonNull IStoriesToStoryDtoConverter storiesToStoryDtoConverter;

    @Override
    public StoryListWrapperDto convert(Page<Stories> value) {

        List<StoryDto> listStoryDto = new ArrayList<>();

        value.getContent().forEach(comics -> listStoryDto.add(storiesToStoryDtoConverter.convert(comics)));

        return StoryListWrapperDto.builder()
                .items(listStoryDto)
                .available(value.getTotalElements())
                .returned(value.getContent().size())
                .build();
    }

}