package br.com.urbainski.api.marvel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Events;
import br.com.urbainski.api.marvel.repository.IEventsRepository;
import br.com.urbainski.api.marvel.service.IEventsService;

@Service
public class EventsServiceImpl extends AbstractDefaultServiceImpl<Events, Long> implements IEventsService {

    @Override
    public Page<Events> findByCharacters(Characters characters, Pageable pageable) {

        return getCastedRepository().findByCharacters(characters, pageable);
    }

    private IEventsRepository getCastedRepository() {

        return (IEventsRepository) repository;
    }

}