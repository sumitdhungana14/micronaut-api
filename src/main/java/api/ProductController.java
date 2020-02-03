package api;

import api.models.User;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller("/product")
public class ProductController {
    private User user;
    @Get("/{name}")
    public String index(String name) {
//        this.user.setUsername("name");
        return "Hello"+name;
    }
}