package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class EventContainerWrapperDto extends AbstractContainerWrapperDto<EventDto> {

    @Builder
    public EventContainerWrapperDto(Long offset, Integer limit, Long total, Integer count,
            List<EventDto> results) {

        super(offset, limit, total, count, results);
    }

}