package org.example.app.repository;

import org.example.app.entities.User;

import java.util.ArrayList;
import java.util.List;

//Userdal,
//UserDao
public class UserRepository  implements BaseUserRepository{
    // In-Memory
    List<User> users = new ArrayList<>();
    public List<User> findAll()
    {
        return users;
    }
    public User findById(int id)
    {
        return users.stream().
                filter(user -> user.getId() ==id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

}
