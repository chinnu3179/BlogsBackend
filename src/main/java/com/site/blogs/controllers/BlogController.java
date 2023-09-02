package com.site.blogs.controllers;

import com.site.blogs.models.Blog;
import com.site.blogs.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/create")
    Blog create(@RequestBody Blog blog){
        return blogService.create(blog);
    }
    @GetMapping("/findByTitle")
    List<Blog> findByTitle(@RequestParam(value = "title") String blogTitle){
        return blogService.findByTitle(blogTitle);
    }
    @GetMapping("/findByCreatedBy")
    List<Blog> findByCreatedBy(@RequestParam(value = "user") String user){
        return blogService.findByCreatedBy(user);
    }
    @PutMapping("/update/{id}")
    Blog update(@RequestBody Blog blog, @PathVariable int id){
        try {
            return blogService.update(blog, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable int id){
        blogService.delete(id);
        return "Successfully Deleted";
    }
}
