package org.example.app;

import org.example.app.entities.User;
import org.example.app.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        // Genel veritabanı.
        UserRepository userRepository = new UserRepository();

        User user = new User();
        user.setId(1);
        user.setEmail("turkcell@gmail.com");
        user.setName("Turkcell");

        userRepository.save(user);

        User user2 = new User();
        user2.setId(2);
        user2.setEmail("turkcell1@gmail.com");
        user2.setName("Turkcell1");

        userRepository.save(user2);

    }
}
