package demo.example.blogspring1.service;

import demo.example.blogspring1.model.Post;


import java.util.List;

public interface PostService  {

    Post create(Post post);

    Post findById(Long id);
    List<Post> findAll();
}
