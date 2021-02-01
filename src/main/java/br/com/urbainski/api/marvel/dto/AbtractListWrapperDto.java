package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbtractListWrapperDto<T> {

    private Long available;
    private Integer returned;
    private List<T> items;

    public AbtractListWrapperDto(Long available, Integer returned, List<T> items) {

        this.available = available;
        this.returned = returned;
        this.items = items;
    }

}