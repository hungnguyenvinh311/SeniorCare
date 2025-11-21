package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.converter.ContentConverter;
import com.hungdev.firstproject.entity.ContentEntity;
import com.hungdev.firstproject.model.ContentDTO;
import com.hungdev.firstproject.repository.ContentRepository;
import com.hungdev.firstproject.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentConverter contentConverter;

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public void addContent(ContentDTO contentDTO) {
        ContentEntity contentEntity = contentConverter.convertToEntity(contentDTO);
        contentRepository.save(contentEntity);
    }

    @Override
    public List<ContentDTO> findByContentType(String contenttype) {
        List<ContentEntity> contentEntities = contentRepository.findByContenttype(contenttype);
        List<ContentDTO> contentDTOS = new ArrayList<>();
        for(ContentEntity it : contentEntities){
            contentDTOS.add(contentConverter.convertToDto(it));
        }
        return contentDTOS;
    }

    @Override
    public void deleteContents(List<Long> contentIds) {
        contentRepository.deleteAllByIdIn(contentIds);
    }
}
