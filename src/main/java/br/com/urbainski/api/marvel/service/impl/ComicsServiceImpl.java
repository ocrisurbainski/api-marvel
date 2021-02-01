package br.com.urbainski.api.marvel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.urbainski.api.marvel.domain.Characters;
import br.com.urbainski.api.marvel.domain.Comics;
import br.com.urbainski.api.marvel.repository.IComicsRepository;
import br.com.urbainski.api.marvel.service.IComicsService;

@Service
public class ComicsServiceImpl extends AbstractDefaultServiceImpl<Comics, Long> implements IComicsService {

    @Override
    public Page<Comics> findByCharacters(Characters characters, Pageable pageable) {

        return getCastedRepository().findByCharacters(characters, pageable);
    }

    private IComicsRepository getCastedRepository() {

        return (IComicsRepository) repository;
    }

}