package demo.example.blogspring1.repository;

import demo.example.blogspring1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
