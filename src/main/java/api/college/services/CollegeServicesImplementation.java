package api.college.services;

import api.college.models.College;
import api.college.repositories.CollegeRepository;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

public class CollegeServicesImplementation implements CollegeServices {

    @Inject
    CollegeRepository collegeRepository;

    @Transactional
    public Optional<College> findById(int id){
        return collegeRepository.findById(id);
    }

    @Transactional
    public Iterable<College> showAllCollege(){
        return collegeRepository.findAll();
    }

    public void add(College college){
        collegeRepository.save(college);
    }

    public void deleteById(int id){
        collegeRepository.deleteById(id);
    }

    public College editCollege(College college){
        return collegeRepository.update(college);
    }
}
