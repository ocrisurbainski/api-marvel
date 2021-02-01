package br.com.urbainski.api.marvel.domain;

public abstract class AbstractDomain<PK> {

    abstract PK getId();

    abstract void setId(PK id);

}