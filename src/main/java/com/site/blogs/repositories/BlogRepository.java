package com.site.blogs.repositories;

import com.site.blogs.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer> {

    @Query("SELECT p FROM Blog p WHERE p.title LIKE %?1%")
    List<Blog> findByTitle(String title);

//    @Modifying
//    @Query("UPDATE Blog s SET s=?1 WHERE s.blogId=?2")
//    void update(Blog blog, int id);
    List<Blog> findByCreatedBy(String user);
}
