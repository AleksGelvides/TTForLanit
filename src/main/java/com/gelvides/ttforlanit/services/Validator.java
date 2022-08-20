package com.gelvides.ttforlanit.services;

public interface Validator<T> {
    void valid(T t) throws Exception;
}
