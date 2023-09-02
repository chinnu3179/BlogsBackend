package com.site.blogs.services.implementations;

import com.site.blogs.models.Blog;
import com.site.blogs.models.Comments;
import com.site.blogs.repositories.BlogRepository;
import com.site.blogs.repositories.CommentsRepository;
import com.site.blogs.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    BlogRepository blogRepository;
    @Override
    public Comments create(Comments comment, int blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(blog.isPresent()) {
            Comments c = new Comments(blog.get(), comment.getCommentContent(), comment.getCreatedBy() );
            return commentsRepository.save(c);
        }
        return null;
    }
}
