package com.syscho.boot.service;

import java.util.List;

public interface GenericService<T> {

    T findById(long id);

    List<T> findAll();

    List<T> findAllByName(String name);

    String deleteById(long id);

    T save(T object);

    T update(T object);

}
