package br.com.urbainski.api.marvel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Series;
import br.com.urbainski.api.marvel.repository.ISeriesRepository;
import br.com.urbainski.api.marvel.service.ISeriesService;

@Service
public class SeriesServiceImpl extends AbstractDefaultServiceImpl<Series, Long> implements ISeriesService {

    @Override
    public Page<Series> findByCharacters(Characters characters, Pageable pageable) {

        return getCastedRepository().findByCharacters(characters, pageable);
    }

    private ISeriesRepository getCastedRepository() {

        return (ISeriesRepository) repository;
    }

}