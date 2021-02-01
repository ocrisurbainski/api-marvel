package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IEventsToEventDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageEventsToEventContainerWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.dto.EventContainerWrapperDto;
import br.com.urbainski.api.marvel.dto.EventDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageEventsToEventContainerWrapperDtoConverterImpl implements
        IPageEventsToEventContainerWrapperDtoConverter {

    private final @NonNull IEventsToEventDtoConverter eventsToEventDtoConverter;

    @Override
    public EventContainerWrapperDto convert(Page<Events> value) {

        List<EventDto> listEventDto = new ArrayList<>();

        value.getContent().forEach(
                events -> listEventDto.add(eventsToEventDtoConverter.convert(events)));

        return EventContainerWrapperDto.builder()
                .offset(value.getPageable().getOffset())
                .limit(value.getPageable().getPageSize())
                .count(value.getContent().size())
                .total(value.getTotalElements())
                .results(listEventDto)
                .build();
    }

}