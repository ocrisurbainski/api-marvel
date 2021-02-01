package br.com.urbainski.api.marvel.repository;

import org.springframework.stereotype.Repository;

import br.com.urbainski.api.marvel.domain.Characters;

@Repository
public interface ICharactersRepository extends IDefaultRepository<Characters, Long> {

}