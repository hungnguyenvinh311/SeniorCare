package com.hungdev.firstproject.service;

import com.hungdev.firstproject.model.ContentDTO;

import java.util.List;


public interface ContentService {
    void addContent(ContentDTO contentDTO);
    List<ContentDTO> findByContentType(String contentType);
    void deleteContents(List<Long> contentIds);
}
