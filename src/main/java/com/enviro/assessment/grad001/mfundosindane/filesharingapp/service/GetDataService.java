package com.enviro.assessment.grad001.mfundosindane.filesharingapp.service;

/*Name:GetDataService
 * 
 *Purpose: To Serve as a abstraction service class for GET in AppController. 
 * 
*/

//imported libraries:
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.FileModel;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository.FileRepository;

@Service
public class GetDataService {
        
    //A instance of the FileRepository interface for data manipulation in the database: 
    @Autowired
    private FileRepository fileRepository;

    //A get method to find all models within the database:
    public List<FileModel> getAllFiles(){
        return (List<FileModel>)fileRepository.findAll();    
    }

    //A get method to find a specific model in the database: 
    public FileModel getFile(Integer id){
        FileModel file =fileRepository.findById(id).get();
        return file;
    }
}
