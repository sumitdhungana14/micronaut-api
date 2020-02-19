package api.user.services;

import api.college.models.College;
import api.college.services.CollegeServices;
import api.user.models.User;
import api.user.models.UserDTO;
import api.user.repositories.UserRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserServiceImplementation implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    CollegeServices collegeServices;

    @Transactional
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public List<UserDTO> showAllUser() {
        return userRepository.list();
    }

    @Transactional
    public User add(User user) {
        //Use try catch here. Know type of exception thrown.
        //user.setCollege(college.get());

        Iterator iter = user.getCollegeId().iterator();
        while (iter.hasNext()) {
            Optional<College> college = collegeServices.findById((int) iter.next());
            user.addCollege(college.get());
        }
        return userRepository.save(user);

    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User editUser(User user, int id) {

        user.setId(id);
        Iterator iter = user.getCollegeId().iterator();
        while (iter.hasNext()) {
            Optional<College> college = collegeServices.findById((int) iter.next());
            user.addCollege(college.get());
        }

        return userRepository.update(user);
    }
}