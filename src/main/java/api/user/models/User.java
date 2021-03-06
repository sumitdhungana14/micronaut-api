package api.user.models;

import api.college.models.College;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import javax.transaction.Transactional;
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

    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "user_college",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name = "college_id"))
    private Set<College> colleges = new HashSet<>();

    @Transient
    @JsonProperty(value = "colleges_id")
    private Iterable<Integer> collegeId;

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

    public Set<College> getColleges() {
        return colleges;
    }

    public void setColleges(Set<College> colleges) {
        this.colleges = colleges;
    }

    public void addCollege(College college) {
        colleges.add(college);
        college.getUsers().add(this);
    }

    public void removeCollege(College college) {
        colleges.remove(college);
        college.getUsers().remove(this);
    }

    public Iterable<Integer> getCollegeId() {
        return collegeId;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
