package com.enviro.assessment.grad001.mfundosindane.filesharingapp.model;

/*Name: FileModel
 * 
 * Purpose: To create a class object for the file content uploaded and retrieved
 * 
*/

//imported libraries: 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name = "fileData")

//File object:
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String file_name;
    
    @Lob
    private String data;

    //get method for id
    public Integer getID(){
        return this.id;
    }

    //get method for file_name
    public String getfile_name(){
        return this.file_name;
    }

    //get method for file data
    public String getData(){
        return this.data;
    }

    //set method for file_name
    public void setfile_name(String file_name){
        this.file_name=file_name;
    }    

    //set method for file data
    public void setData(String data){
        this.data=data;
    }

}