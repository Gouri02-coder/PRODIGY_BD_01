package com.example.CRUD_Operation;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<UUID, User> users = new HashMap<>();

    public User createUser(User user) {
        UUID id = UUID.randomUUID();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(UUID id) {
        return users.get(id);
    }

    public User updateUser(UUID id, User updatedUser) {
        User existingUser = users.get(id);
        if (existingUser == null) {
            return null;
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAge(updatedUser.getAge());

        return existingUser;
    }

    public boolean deleteUser(UUID id) {
        return users.remove(id) != null;
    }
}
