package user.repositories;

import user.models.User;
import user.models.UserDTO;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;


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
    List<UserDTO> list();

//    UserDTO listById(int id);
}
