package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class SerieListWrapperDto extends AbtractListWrapperDto<SerieDto> {

    @Builder
    public SerieListWrapperDto(Long available, Integer returned, List<SerieDto> items) {

        super(available, returned, items);
    }

}