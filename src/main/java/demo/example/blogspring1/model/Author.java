package demo.example.blogspring1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity


public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @NotEmpty(message = "{author.name.validator.msg}")
        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Past(message = "Date of Birht must be past")
        private LocalDate dateOfBirht;
        @NotEmpty(message = "Please Enter Something")
        private String interested;
        @Enumerated(EnumType.STRING)
        private Gender gender;

    public Author(String name, LocalDate dateOfBirht, String interested, Gender gender) {
        this.name = name;
        this.dateOfBirht = dateOfBirht;
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

    public LocalDate getDateOfBirht() {
        return dateOfBirht;
    }

    public void setDateOfBirht(LocalDate dateOfBirht) {
        this.dateOfBirht = dateOfBirht;
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
