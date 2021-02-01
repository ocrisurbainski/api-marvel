package br.com.urbainski.api.marvel.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.urbainski.api.marvel.domain.AbstractDomain;

public interface IDefaultService<DOMAIN extends AbstractDomain<PK>, PK> {

    Optional<DOMAIN> findById(PK id);

    Page<DOMAIN> findAll(Pageable pageable);

}