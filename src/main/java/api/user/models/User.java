package api.user.models;

import api.college.models.College;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
@Introspected
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "college_id")
    @JsonProperty(value = "college_id")
    private int collegeId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_college",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name = "college_id"))
    private Set<College> colleges = new HashSet<>();

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public Set<College> getCollege() {
        return colleges;
    }

    public void setCollege(Set<College> colleges) {
        this.colleges = colleges;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void addCollege(College college) {
        colleges.add(college);
//        college.getUsers().add(this);
    }

    public void removeCollege(College college) {
        colleges.remove(college);
//        college.getUsers().remove(this);
    }

}
