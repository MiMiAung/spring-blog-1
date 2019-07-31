package demo.example.blogspring1.controller;

import demo.example.blogspring1.model.Author;
import demo.example.blogspring1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthorController  {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public String create(Model model){


        model.addAttribute("author",new Author());
        return "authorForm";
    }
    @PostMapping("/author")
    public  String process(@Valid Author author, BindingResult result){
        if(result.hasErrors()){
            return "authorForm";
        }
        authorService.create(author);

        return "redirect:/authors";

    }
    @GetMapping("/authors")
    public  String showAllAuthors(Model model){
        model.addAttribute("authors",authorService.findAll());
        return "authors";
    }
}