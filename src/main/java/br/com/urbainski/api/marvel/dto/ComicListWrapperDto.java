package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class ComicListWrapperDto extends AbtractListWrapperDto<ComicDto> {

    @Builder
    public ComicListWrapperDto(Long available, Integer returned, List<ComicDto> items) {

        super(available, returned, items);
    }

}