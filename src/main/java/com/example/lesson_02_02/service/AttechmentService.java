package com.example.lesson_02_02.service;

import com.example.lesson_02_02.entity.Attechment;
import com.example.lesson_02_02.entity.AttechmentContent;
import com.example.lesson_02_02.payload.response.ApiResponse;
import com.example.lesson_02_02.repository.AttechmentContentRepository;
import com.example.lesson_02_02.repository.AttechmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;

@Service
public class AttechmentService {
    @Autowired
    AttechmentRepository attechmentRepository;
    @Autowired
    AttechmentContentRepository attechmentContentRepository;
    @SneakyThrows
    public ApiResponse add(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attechment attachment = new Attechment();
            attachment.setName(originalFilename);
            attachment.setContentType(contentType);
            attachment.setSize(size);
            Attechment save = attechmentRepository.save(attachment);

            AttechmentContent attechmentConten = new AttechmentContent();
            attechmentConten.setBytes(file.getBytes());
            attechmentConten.setAttechmentId(save);
            attechmentContentRepository.save(attechmentConten);
            return new ApiResponse("File saqlandi", true);

        }
        return new ApiResponse("Saqlanmadi", false);
    }
}
