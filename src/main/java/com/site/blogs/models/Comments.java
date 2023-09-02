package com.site.blogs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Comments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comments {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blogId")
    private Blog blog;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commentId;
    String commentContent;
    Timestamp CreatedAt;
    String CreatedBy;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        CreatedAt = createdAt;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public Comments(Blog blog, String commentContent, String createdBy) {
        this.blog = blog;
        this.commentContent = commentContent;
        this.CreatedAt = new java.sql.Timestamp(System.currentTimeMillis());
        CreatedBy = createdBy;
    }
}
