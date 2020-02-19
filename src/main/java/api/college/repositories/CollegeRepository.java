package api.college.repositories;

import api.college.models.College;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * automatically implements all the crud operation in User model
 * CrudRepository<MODEL_NAME, TYPE_OF_PRIMARY_KEY>
 */
@Repository
public interface CollegeRepository extends CrudRepository<College, Integer> {

}
