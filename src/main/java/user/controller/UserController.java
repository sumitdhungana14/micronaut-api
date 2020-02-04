package user.controller;

import user.models.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import user.repositories.UserRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/user")
public class UserController {

    @Inject UserRepository userRepository;

    @Get("/{id}")
    public HttpResponse getUserbyId(int id){
        return HttpResponse.ok().body(userRepository.findById(id));
    }

    @Get("/")
    public Iterable<UserDTO> index() {
        return userRepository.list();
    }

    @Post("/addUser")
    public HttpResponse addUser(@Body @Valid User user){
        userRepository.save(user);
        return HttpResponse.ok();
    }

    @Delete("/{id}")
    public HttpResponse deleteUserbyId(@NotNull int id){
        userRepository.deleteById(id);
        return HttpResponse.ok();
    }

    @Put("/{id}")
    public HttpResponse editUser(@Body User user, int id){
        user.setId(id);
        userRepository.update(user);
        return HttpResponse.ok();
    }


}