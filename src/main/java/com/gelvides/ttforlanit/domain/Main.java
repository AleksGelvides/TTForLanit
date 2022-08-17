package com.gelvides.ttforlanit.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public abstract class Main {

    @NotNull
    private final Long id;

    public Main(Long id) {
        this.id = id;
    }
}
