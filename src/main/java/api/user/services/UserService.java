package api.user.services;


import api.user.models.User;
import api.user.models.UserDTO;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public interface UserService {

    Optional<User> findById(int id);

    List<UserDTO> showAllUser();

    void add(User user);

    void deleteById(int id);

    User editUser(User user);
}