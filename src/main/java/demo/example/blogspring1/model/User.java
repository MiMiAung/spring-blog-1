package demo.example.blogspring1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity



public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "first name can not be empty.")
    private String firstName;
    @NotEmpty(message = "last name can not be empty.")
    private String lastName;
    @Transient
    private String fullName;
    @NotEmpty(message = "passwore cannot be empty.")
    private String password;
    @NotEmpty(message = "email connot be empty.")
    private String email;
    @Transient
    private String confirmPassword;

    public User() {
    }

    public User(@NotEmpty(message = "first name can not be empty.") String firstName, @NotEmpty(message = "last name can not be empty.") String lastName, @NotEmpty(message = "passwore cannot be empty.") String password, @NotEmpty(message = "email connot be empty.") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();

    public  void addRole(Role role){
        roles.add(role);
    }

    public void addRoles(List<Role> roles){
       // roles.addAll(roles);
        roles.forEach(this::addRole);
    }

}
