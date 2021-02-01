package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class StoryContainerWrapperDto extends AbstractContainerWrapperDto<StoryDto> {

    @Builder
    public StoryContainerWrapperDto(Long offset, Integer limit, Long total, Integer count,
            List<StoryDto> results) {

        super(offset, limit, total, count, results);
    }

}