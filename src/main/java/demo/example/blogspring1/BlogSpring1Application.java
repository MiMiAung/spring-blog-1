package demo.example.blogspring1;

import demo.example.blogspring1.model.Author;
import demo.example.blogspring1.model.Gender;
import demo.example.blogspring1.model.Post;
import demo.example.blogspring1.repository.AuthorRepository;
import demo.example.blogspring1.repository.PostRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class BlogSpring1Application {
    private  static Logger logger= LoggerFactory.getLogger(BlogSpring1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogSpring1Application.class, args);
        System.out.println("Welcome Gitts");
    }

    @Bean

    public PrettyTime prettyTime(){
        return new PrettyTime();
    }

    @Bean
    @Profile("dev")

    public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
        return args -> {

            Author author1 = new Author("Thaw Thaw", LocalDate.of(2000, 3, 24), "Horror", Gender.MALE);

            Post p1 = new Post("afeaf", "deirjufew", LocalDate.now());
            Post p2 = new Post("afeaf", "deirjufew", LocalDate.now());
            Post p3 = new Post("afeaf", "deirjufew", LocalDate.now());

            p1.setAuthor(author1);
            p2.setAuthor(author1);
            p3.setAuthor(author1);

            authorRepository.save(author1);
            postRepository.save(p1);
            postRepository.save(p2);
            postRepository.save(p3);

            logger.info("successfully create.");


        };
    }

}
