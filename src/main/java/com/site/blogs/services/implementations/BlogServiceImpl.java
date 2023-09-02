package com.site.blogs.services.implementations;

import com.site.blogs.models.Blog;
import com.site.blogs.repositories.BlogRepository;
import com.site.blogs.services.BlogService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    @Transactional
    public Blog update(Blog blog, int id) throws Exception {
        Optional<Blog> blogFromDb = blogRepository.findById(id);
        Blog b = new Blog(blog.title,blog.content,blog.createdBy);
        b.setBlogId(id);
        b.setLastUpdateAt(new java.sql.Timestamp(System.currentTimeMillis()));
        if(blogFromDb.isPresent())
            b.setCreatedAt(blogFromDb.get().getCreatedAt());
        else{
            throw new Exception("No Blog found");
        }
        return blogRepository.save(b);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog create(Blog blog) {
        Blog b = new Blog(blog.title,blog.content,blog.createdBy);
        b.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        return  blogRepository.save(b);
    }

    @Override
    public List<Blog> findByTitle(String blogTitle) {
        return blogRepository.findByTitle(blogTitle);
    }

    @Override
    public List<Blog> findByCreatedBy(String user) {
        return blogRepository.findByCreatedBy(user);
    }
}
