package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class SerieContainerWrapperDto extends AbstractContainerWrapperDto<SerieDto> {

    @Builder
    public SerieContainerWrapperDto(Long offset, Integer limit, Long total, Integer count,
            List<SerieDto> results) {

        super(offset, limit, total, count, results);
    }

}