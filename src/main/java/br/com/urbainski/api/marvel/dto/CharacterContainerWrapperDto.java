package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class CharacterContainerWrapperDto extends AbstractContainerWrapperDto<CharacterDto> {

    @Builder
    public CharacterContainerWrapperDto(Long offset, Integer limit, Long total, Integer count,
            List<CharacterDto> results) {

        super(offset, limit, total, count, results);
    }

}