package org.example.app.repository;


import java.util.List;

public interface BaseRepository<T>
{
    T findById(int id);
    List<T> findAll();
    void save(T t);
    void delete(T t);
}
