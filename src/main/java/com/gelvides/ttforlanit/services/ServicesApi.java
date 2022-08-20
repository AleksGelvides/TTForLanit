package com.gelvides.ttforlanit.services;
public interface ServicesApi<T>{

    void save(T t) throws Exception;

    T getEntity(long id) throws Exception;

}
