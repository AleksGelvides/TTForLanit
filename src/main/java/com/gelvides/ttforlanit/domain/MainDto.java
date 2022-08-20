package com.gelvides.ttforlanit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public abstract class MainDto {

    @NotNull
    @Min(1)
    private final Long id;

    public MainDto(Long id) {
        this.id = id;
    }
}
