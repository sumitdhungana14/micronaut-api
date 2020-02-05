package api.college.models;

import javax.persistence.*;

@Entity(name = "college")
public class College {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;


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
