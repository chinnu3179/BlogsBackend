package com.site.blogs.controllers;

import com.site.blogs.models.Comments;
import com.site.blogs.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentsService commentsService;

    @PostMapping("/create/{id}")
    Comments create(@RequestBody  Comments comment, @PathVariable int id){
        return commentsService.create(comment,id);
    }
}
