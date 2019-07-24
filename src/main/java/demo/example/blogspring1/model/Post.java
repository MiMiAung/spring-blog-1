package demo.example.blogspring1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    @Lob
    @Column(length = 100000)
    private String body;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdated;
    @ManyToOne
    private Author author;

    public Post(String tag, String body, LocalDate lastUpdated) {
        this.tag = tag;
        this.body = body;
        this.lastUpdated = lastUpdated;
    }

    public Post(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
