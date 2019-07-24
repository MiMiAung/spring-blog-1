package demo.example.blogspring1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

@Data

public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;
        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfBirht;
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
}
