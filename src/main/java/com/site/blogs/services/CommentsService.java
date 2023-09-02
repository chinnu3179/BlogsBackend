package com.site.blogs.services;

import com.site.blogs.models.Comments;

public interface CommentsService {

    Comments create(Comments comment, int id);
}
