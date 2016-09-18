package ba.jamax.service;

import ba.jamax.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
