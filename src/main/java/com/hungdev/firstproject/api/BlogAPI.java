package com.hungdev.firstproject.api;

import com.hungdev.firstproject.model.BlogDTO;
import com.hungdev.firstproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/blogs")
@Transactional
public class BlogAPI {


    @Autowired
    private BlogService blogService;

    @PostMapping
    public void addNewBlogs(@RequestBody BlogDTO newBlogs){
        blogService.addBlogs(newBlogs);
    }


    @GetMapping
    public List<BlogDTO> findBlogsByCategory(@RequestParam String categoryName){
        List<BlogDTO> dtos = blogService.findBlogsByCategoryType(categoryName);
        return dtos;
    }



}
