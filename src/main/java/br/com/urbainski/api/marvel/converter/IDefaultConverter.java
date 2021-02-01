package br.com.urbainski.api.marvel.converter;

public interface IDefaultConverter<FROM, TO> {

    TO convert(FROM value);

}
