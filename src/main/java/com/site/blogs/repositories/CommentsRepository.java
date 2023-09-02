package com.site.blogs.repositories;

import com.site.blogs.models.Comments;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comments,Integer> {
}
