package br.com.urbainski.api.marvel.converter.impl;

import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IStoriesToStoryDtoConverter;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.dto.StoryDto;

@Component
public class StoriesToStoryDtoConverterImpl implements IStoriesToStoryDtoConverter {

    @Override
    public StoryDto convert(Stories value) {

        return new StoryDto(value.getId(), value.getName(), value.getType().name());
    }

}