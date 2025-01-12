package com.ushan.Joblisting.controller;

import com.ushan.Joblisting.model.Post;
import com.ushan.Joblisting.repo.PostRepository;
import com.ushan.Joblisting.repo.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepository;

    @Hidden
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @GetMapping("/post/{text}")
    public List<Post> searchPost(@PathVariable String text){
        return searchRepository.findByText(text);
    }

}
