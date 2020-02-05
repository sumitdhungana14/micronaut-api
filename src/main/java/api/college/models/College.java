package api.college.models;

import api.user.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "college")
public class College {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

//    @OneToMany
//    @JoinColumn(name = "college_id" )
//    private List<User> users= new ArrayList<User>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
