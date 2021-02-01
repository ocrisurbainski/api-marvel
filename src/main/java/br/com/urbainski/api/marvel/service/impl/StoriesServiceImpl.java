package br.com.urbainski.api.marvel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Stories;
import br.com.urbainski.api.marvel.repository.IStoriesRepository;
import br.com.urbainski.api.marvel.service.IStoriesService;

@Service
public class StoriesServiceImpl extends AbstractDefaultServiceImpl<Stories, Long> implements IStoriesService {

    @Override
    public Page<Stories> findByCharacters(Characters characters, Pageable pageable) {

        return getCastedRepository().findByCharacters(characters, pageable);
    }

    private IStoriesRepository getCastedRepository() {

        return (IStoriesRepository) repository;
    }

}