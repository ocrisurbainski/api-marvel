package br.com.urbainski.api.marvel.converter.impl;

import org.springframework.stereotype.Component;

import br.com.urbainski.api.marvel.converter.IEventsToEventDtoConverter;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.dto.EventDto;

@Component
public class EventsToEventDtoConverterImpl implements IEventsToEventDtoConverter {

    @Override
    public EventDto convert(Events value) {

        return new EventDto(value.getId(), value.getName());
    }

}