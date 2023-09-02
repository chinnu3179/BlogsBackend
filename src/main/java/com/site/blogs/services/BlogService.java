package com.site.blogs.services;

import com.site.blogs.models.Blog;

import java.util.List;

public interface BlogService {
    Blog update(Blog blog, int id) throws Exception;
    void delete(int id);
    Blog create(Blog blog);
    List<Blog> findByTitle(String blogTitle);

    List<Blog> findByCreatedBy(String blogContent);
}
