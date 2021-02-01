package br.com.urbainski.api.marvel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.urbainski.api.marvel.domain.AbstractDomain;

@NoRepositoryBean
public interface IDefaultRepository<DOMAIN extends AbstractDomain<PK>, PK> extends JpaRepository<DOMAIN, PK> {

}