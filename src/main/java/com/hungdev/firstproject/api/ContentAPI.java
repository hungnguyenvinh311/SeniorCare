package com.hungdev.firstproject.api;


import com.hungdev.firstproject.model.ContentDTO;
import com.hungdev.firstproject.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/api/content")
public class ContentAPI {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getContent(
            @RequestParam(name = "contentType", required = false) String contentType) {

        List<ContentDTO> contentList;
//        if (contentType != null && !contentType.isEmpty()) {
//            contentList = contentRepository.findByContentType(contentType.toUpperCase());
//        } else {
//            contentList = contentRepository.findAll();
//        }

        contentList = contentService.findByContentType(contentType.toUpperCase());

        return ResponseEntity.ok(contentList);
    }


    @PostMapping
    public void addContent(@RequestBody ContentDTO newContent) {
        contentService.addContent(newContent);
        System.out.println("Đã thêm nội dung mới thành công");
    }


    @DeleteMapping("/{ids}")
    public void deleteContents(@PathVariable List<Long> ids){
        contentService.deleteContents(ids);
    }
}
