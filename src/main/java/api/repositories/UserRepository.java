package api.repositories;

import api.models.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.Optional;

/**
 * automatically implements all the crud operation in User model
 * CrudRepository<MODEL_NAME, TYPE_OF_PRIMARY_KEY>
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
