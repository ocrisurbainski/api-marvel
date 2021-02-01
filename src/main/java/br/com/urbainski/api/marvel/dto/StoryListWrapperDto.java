package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class StoryListWrapperDto extends AbtractListWrapperDto<StoryDto> {

    @Builder
    public StoryListWrapperDto(Long available, Integer returned, List<StoryDto> items) {

        super(available, returned, items);
    }

}