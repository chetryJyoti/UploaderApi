package com.moreOpp.dataUploader.UploaderApi.Controller;

import com.moreOpp.dataUploader.UploaderApi.Entity.Internship;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelHelper;
import com.moreOpp.dataUploader.UploaderApi.Service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class InternshipController {

    @Autowired
    private InternshipService internshipService;


    @PostMapping("internship/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException{
        if(ExcelHelper.checkExcelFileFormat(file)){
//            true
            this.internshipService.saveInternship(file);
            return ResponseEntity.ok(Map.of("message","internship file uploaded successfully to database"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel files only!");

    }
    @GetMapping("internships")
    public List<Internship> allInternships(){
        return this.internshipService.getAllInternships();
    }

    @DeleteMapping("/deleteAllInternships")
    public ResponseEntity<?> deleteAlL(){
        try {
            this.internshipService.deleteAllInternships();
            return ResponseEntity.ok(Map.of("Message","all internships deleted successfully"));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You are not authorized to perform this operation!!!");
        }
    }
}
