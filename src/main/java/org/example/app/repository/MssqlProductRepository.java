package org.example.app.repository;

import org.example.app.entities.User;

import java.util.List;

public class MssqlProductRepository implements BaseProductRepository,BaseUserRepository{
    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
