package com.solvd.db.jdbc.interfaces;

import java.util.List;

interface IBaseDao<T> {

    //CRUD operations
    void insert(T t);

    void update(T t);

    void deleteById(int id);

    T getById(int id);

    List<T> getAll();
}