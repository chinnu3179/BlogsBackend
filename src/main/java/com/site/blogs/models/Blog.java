package com.site.blogs.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "blog")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    @Id
    @Column(name = "BlogId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int blogId;

    @Column(name = "BlogTitle")
    public String title;
    @Column(name = "BlogContent")
    public String content;
    @Column(name = "CreatedBy")
    public String createdBy;

//    public Blog() {
//
//    }

    //    @OneToMany(mappedBy = "blog")
//    List<Comments> commentsList ;
    public int getBlogId() {
        return blogId;
    }

    public Timestamp getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Timestamp lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "CreatedAt")
    Timestamp createdAt;

    @Column(name = "UpdateAt")
    Timestamp lastUpdateAt ;

    public Blog(String title, String content,String createdBy){
        this.content = content;
        this.title = title;
        this.lastUpdateAt = null;
        this.createdBy = createdBy;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}
