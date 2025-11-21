package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.BlogDTO;

import java.util.List;

public interface BlogService {
    List<BlogDTO> findBlogsByCategoryType(String typeName);

    void addBlogs(BlogDTO newBlogs);
}
