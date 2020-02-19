package api.college.models;

import api.user.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "college")
public class College {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "colleges", fetch = FetchType.LAZY)
    private Set<User> users= new HashSet<>();

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
