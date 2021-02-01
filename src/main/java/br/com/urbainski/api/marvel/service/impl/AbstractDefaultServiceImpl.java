package br.com.urbainski.api.marvel.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.AbstractDomain;
import br.com.urbainski.api.marvel.repository.IDefaultRepository;
import br.com.urbainski.api.marvel.service.IDefaultService;

import lombok.NonNull;

public abstract class AbstractDefaultServiceImpl<DOMAIN extends AbstractDomain<PK>, PK> implements
        IDefaultService<DOMAIN, PK> {

    @Autowired
    protected IDefaultRepository<DOMAIN, PK> repository;

    @Override
    public Optional<DOMAIN> findById(PK id) {

        return repository.findById(id);
    }

    @Override
    public Page<DOMAIN> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

}