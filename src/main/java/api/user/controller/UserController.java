package api.user.controller;

import api.college.models.College;
import api.college.services.CollegeServices;
import api.user.models.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import api.user.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller("/user")
public class UserController {

    @Inject
    UserService userService;

    @Inject
    CollegeServices collegeServices;

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
        //fetch college by collegeId
        //user.setCollege();

        return HttpResponse.ok().body(userService.add(user));
    }

    @Delete("/{id}")
    public HttpResponse deleteUserbyId(@NotNull int id){
        userService.deleteById(id);
        return HttpResponse.ok();
    }

    @Put("/{id}")
    public HttpResponse editUser(@Body User user, int id){
        user.setId(id);
        User newUser = userService.editUser(user);
        return HttpResponse.ok().body(newUser);
    }


}