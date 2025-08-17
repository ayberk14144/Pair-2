package org.example.EMiniTicaret.repository;

import java.util.List;

public interface IRepository<T> {
    void add(T entity);
    void remove(int id);
    T findById(int id);
    List<T> findAll();
}
