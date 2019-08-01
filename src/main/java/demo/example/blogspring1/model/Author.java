package demo.example.blogspring1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

@Entity


public class Author implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @NotEmpty(message = "{author.name.validator.msg}")
        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Past(message = "Birthday must be past!")
        private LocalDate dateOfBirth;
        @NotEmpty(message = "Please Enter Something")
        private String interested;
        @Enumerated(EnumType.STRING)
        private Gender gender;

    public Author(String name, LocalDate dateOfBirth, String interested, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.interested = interested;
        this.gender = gender;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
