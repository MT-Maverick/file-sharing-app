package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.FileModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;

@Service
public class PostDataService {
    @Autowired
    private FileRepository fileRepository;

    public void saveFile(MultipartFile file)throws IOException{
        FileModel fileData = new FileModel();
        fileData.setfile_name(file.getOriginalFilename());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        fileData.setDate(dtf.format(localDateTime));
        
        String data = new String(file.getBytes(),StandardCharsets.UTF_8);
        fileData.setData(data);

        fileRepository.save(fileData);
    
    
    }

}
