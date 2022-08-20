package com.gelvides.ttforlanit.services;

import java.util.List;

public interface ServicesApi<T>{

    void save(T t) throws Exception;

    T getEntity(long id) throws Exception;

}
