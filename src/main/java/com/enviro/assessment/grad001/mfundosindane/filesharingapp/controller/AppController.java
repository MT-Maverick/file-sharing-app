package com.enviro.assessment.grad001.mfundosindane.filesharingapp.controller;

import java.net.URI;

/*Name:AppController:
 * 
 *Purpose: To facilitate RESTful endpoints GET and POST for the Application.
 * 
*/

//imported libraries:
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.FileModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.GetDataService;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.service.PostDataService;

@RestController
public class AppController {
    //The POST service class used to abstract data processing from data manipulation: 
    @Autowired
    private PostDataService PDS;
    
    //The GET service class used to abstract data processing from data manipulation:
    @Autowired
    private GetDataService GDS;

    //POST method used to upload text file: 
    @PostMapping("/index")
    public ResponseEntity<String> uploadFile(@RequestPart("file")MultipartFile file)

    {
        
        if(file.isEmpty())
        return ResponseEntity.badRequest().body("<center>File is empty</br>Click on the back button to return to home</center>");
        
        try {

            PDS.saveFile(file);
            return ResponseEntity.ok("<center>File: "+file.getOriginalFilename()+"</br>SUCESSFULY UPLOADED!!</br><a href=\"index.html\">Click here to return to home</a></center>");
        } catch (Exception e) {
         return ResponseEntity.badRequest().body("Failed to load file" + e.getMessage() );   
        }
    }
    
    //GET method used to retrieve the whole database:
    @GetMapping("/data")
    public ResponseEntity<List<FileModel>> getAllData(){
        
        return ResponseEntity.ok(GDS.getAllFiles());
    }
    
    //GET method used to retrieve a single entity:
    @GetMapping("/data/{id}")
    public ResponseEntity<FileModel>getData(@PathVariable Integer id){
        return ResponseEntity.ok(GDS.getFile(id));
    }

    
    //Exception Handlers:
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File size exceeds the limit");
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + ex.getMessage());
    }

}
