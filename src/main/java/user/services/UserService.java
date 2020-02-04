package user.services;


import user.models.User;
import user.models.UserDTO;
import user.repositories.UserRepository;

import javax.inject.Inject;
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
