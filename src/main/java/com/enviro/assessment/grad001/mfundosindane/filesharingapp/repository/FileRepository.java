package com.enviro.assessment.grad001.mfundosindane.filesharingapp.repository;

/*Name: FileRepository
 * 
 * Purpose: To act as a interface for the webapp and the database
*/


//imported libraries:
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.enviro.assessment.grad001.mfundosindane.filesharingapp.model.FileModel;


//Repository for FileModel 
@Repository
public interface FileRepository extends CrudRepository<FileModel,Integer>{
}