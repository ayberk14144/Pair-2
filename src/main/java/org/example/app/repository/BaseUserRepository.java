package org.example.app.repository;


import java.util.ArrayList;
import java.util.List;


// UserDal, UserDao
public class BaseUserRepository implements BaseRepository<User>
{
    // In-Memory
    List<User> users = new ArrayList<>();


    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(User user) {

    }
}