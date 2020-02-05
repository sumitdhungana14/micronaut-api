package api.college.services;


import api.college.models.College;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public interface CollegeServices {

    Optional<College> findById(int id);

    Iterable<College> showAllCollege();

    void add(College college);

    void deleteById(int id);

    College editCollege(College college);
}