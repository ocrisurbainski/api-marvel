package br.com.urbainski.api.marvel.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IEventsToEventDtoConverter;
import br.com.urbainski.api.marvel.converter.IPageEventsToEventListWrapperDtoConverter;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.dto.EventDto;
import br.com.urbainski.api.marvel.dto.EventListWrapperDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PageEventsToEventListWrapperDtoConverterImpl implements IPageEventsToEventListWrapperDtoConverter {

    private final @NonNull IEventsToEventDtoConverter eventsToEventDtoConverter;

    @Override
    public EventListWrapperDto convert(Page<Events> value) {

        List<EventDto> listEventDto = new ArrayList<>();

        value.getContent().forEach(comics -> listEventDto.add(eventsToEventDtoConverter.convert(comics)));

        return EventListWrapperDto.builder()
                .items(listEventDto)
                .available(value.getTotalElements())
                .returned(value.getContent().size())
                .build();
    }

}
