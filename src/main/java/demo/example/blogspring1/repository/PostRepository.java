package demo.example.blogspring1.repository;

import demo.example.blogspring1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
