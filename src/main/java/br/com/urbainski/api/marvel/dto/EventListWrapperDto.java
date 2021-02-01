package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Builder;

public class EventListWrapperDto extends AbtractListWrapperDto<EventDto> {

    @Builder
    public EventListWrapperDto(Long available, Integer returned, List<EventDto> items) {

        super(available, returned, items);
    }
    
}