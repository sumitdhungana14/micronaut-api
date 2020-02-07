package api.user.services;

import api.college.models.College;
import api.college.services.CollegeServices;
import api.user.models.User;
import api.user.models.UserDTO;
import api.user.repositories.UserRepository;
import io.micronaut.http.HttpResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class UserServiceImplementation implements UserService{

    @Inject
    UserRepository userRepository;

    @Inject
    CollegeServices collegeServices;

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public List<UserDTO> showAllUser(){
        return userRepository.list();
    }

    public <T> T add(User user){
        //Use try catch here. Know type of exception thrown.
        Optional<College> college = collegeServices.findById(user.getCollegeId());
        if (college.isEmpty()) return (T)"College not Found!";
        user.setCollege(college.get());
        User savedUser = userRepository.save(user);
        return (T)savedUser;
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User editUser(User user){
        return userRepository.update(user);
    }
}
