package api.college.controller;

import api.college.models.College;
import api.college.services.CollegeServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/college")
public class CollegeController {

    @Inject
    CollegeServices collegeServices;

    @Get("/{id}")
    public HttpResponse getCollegeById(int id){
        return HttpResponse.ok().body(collegeServices.findById(id));
    }

    @Get("/")
    public Iterable<College> index() {
        return collegeServices.showAllCollege();
    }

    @Post("/addCollege")
    public HttpResponse addCollege(@Body @Valid College college){
        collegeServices.add(college);
        return HttpResponse.ok();
    }

    @Delete("/{id}")
    public HttpResponse deleteCollegebyId(@NotNull int id){
        collegeServices.deleteById(id);
        return HttpResponse.ok();
    }

    @Put("/{id}")
    public HttpResponse editCollege(@Body College college, int id){
        college.setId(id);
        College newCollege = collegeServices.editCollege(college);
        return HttpResponse.ok().body(newCollege);
    }
}
