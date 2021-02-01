package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class ComicContainerWrapperDto extends AbstractContainerWrapperDto<ComicDto> {

    @Builder
    public ComicContainerWrapperDto(Long offset, Integer limit, Long total, Integer count,
            List<ComicDto> results) {

        super(offset, limit, total, count, results);
    }

}