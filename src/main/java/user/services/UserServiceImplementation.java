package user.services;

import user.models.User;
import user.models.UserDTO;
import user.repositories.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class UserServiceImplementation implements UserService{

    @Inject
    UserRepository userRepository;

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }


    public List<UserDTO> showAllUser(){
        return userRepository.list();
    }

    public void add(User user){
        userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public void editUser(User user){
        userRepository.update(user);
    }
}
