package br.com.urbainski.api.marvel.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractContainerWrapperDto<T> {

    private Long offset;
    private Integer limit;
    private Long total;
    private Integer count;
    private List<T> results;

    public AbstractContainerWrapperDto(Long offset, Integer limit, Long total, Integer count, List<T> results) {

        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.results = results;
    }

}