package com.hungdev.firstproject.entity;


import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "Blogcategories")
public class BlogCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlogEntity> blogs;
}
