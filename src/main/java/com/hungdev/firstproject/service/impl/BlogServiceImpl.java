package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.BlogConverter;
import com.hungdev.firstproject.entity.BlogCategoryEntity;
import com.hungdev.firstproject.entity.BlogEntity;
import com.hungdev.firstproject.model.BlogDTO;
import com.hungdev.firstproject.repository.BlogCategoryRepository;
import com.hungdev.firstproject.repository.BlogRepository;
import com.hungdev.firstproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogCategoryRepository blogCategoryRepository;

    @Autowired
    private BlogConverter blogConverter;

    @Override
    public List<BlogDTO> findBlogsByCategoryType(String typeName) {
        List<BlogEntity> blogEntities = blogRepository.findByCategoryName(typeName);
        List<BlogDTO> dtos = new ArrayList<>();
        for(BlogEntity it : blogEntities){
            dtos.add(blogConverter.convertToDto(it));
        }

        return dtos;
    }


    @Override
    public void addBlogs(BlogDTO newBlogs) {
        BlogCategoryEntity blogCategory = blogCategoryRepository.findById(newBlogs.getCategoryId()).get();
        BlogEntity blogEntity = blogConverter.convertToEntity(newBlogs);
        blogEntity.setCategory(blogCategory);
        blogRepository.save(blogEntity);

    }
}
