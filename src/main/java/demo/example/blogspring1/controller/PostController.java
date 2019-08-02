package demo.example.blogspring1.controller;

import demo.example.blogspring1.model.Post;
import demo.example.blogspring1.service.AuthorService;
import demo.example.blogspring1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private AuthorService authorService;


    @GetMapping("/post")
    public String create(Model model){
        model.addAttribute("post",new Post());
        model.addAttribute("authors",authorService.findAll());
        return "postForm";
    }


    @PostMapping("/post")
    public String process(@Valid Post post, BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "postForm";
        }

        postService.create(post);

        redirectAttributes.addFlashAttribute("insert",true);

        return "redirect:/posts";
    }


    @GetMapping("/posts")
    public String showAllPost(Model model){
        model.addAttribute("posts",postService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        model.addAttribute("insert",model.containsAttribute("insert"));
        model.addAttribute("delete",model.containsAttribute("delete"));


        return "posts";
    }
    @GetMapping("/posts/details/{id}")
    public String showDetails(Model model,@PathVariable("id") Long id){
        model.addAttribute("post",postService.findById(id));

        return "postDetails";

    }
    @GetMapping("/posts/update/{id}")
    public String updatePost(@PathVariable("id") Long id,Model model){
        this.updatedId=id;
        model.addAttribute("post",postService.findById(id));
        model.addAttribute("authors",authorService.findAll());
        return "postUpdateForm";


    }
    @PostMapping("/posts/update")
    public String processPost(Post post,  RedirectAttributes redirectAttributes){
       postService.update(updatedId,post);
       redirectAttributes.addFlashAttribute("success",true);


       return  "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public  String deletePost(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        postService.delete(id);
        redirectAttributes.addFlashAttribute("delete",true);
        return "redirect:/posts";

    }

    private Long updatedId;




}

