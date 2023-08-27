package com.salceda.ToDo.Service;

import com.salceda.ToDo.Exception.UserNotFoundException;
import com.salceda.ToDo.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(long id) throws UserNotFoundException;
    List<User> getAllUsers();
    User updateUser(long id, User updatedUser) throws UserNotFoundException;
    void deleteUser(long id);
}
