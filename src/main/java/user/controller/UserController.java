package user.controller;

import user.models.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import user.repositories.UserRepository;
import user.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/user")
public class UserController {

    @Inject
    UserService userService;

    @Get("/{id}")
    public HttpResponse getUserbyId(int id){
        return HttpResponse.ok().body(userService.findById(id));
    }

    @Get("/")
    public Iterable<UserDTO> index() {
        return userService.showAllUser();
    }

    @Post("/addUser")
    public HttpResponse addUser(@Body @Valid User user){
        userService.add(user);
        return HttpResponse.ok();
    }

    @Delete("/{id}")
    public HttpResponse deleteUserbyId(@NotNull int id){
        userService.deleteById(id);
        return HttpResponse.ok();
    }

    @Put("/{id}")
    public HttpResponse editUser(@Body User user, int id){
        user.setId(id);
        userService.editUser(user);
        return HttpResponse.ok();
    }


}