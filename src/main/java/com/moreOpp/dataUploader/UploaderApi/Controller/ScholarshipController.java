package com.moreOpp.dataUploader.UploaderApi.Controller;

import com.moreOpp.dataUploader.UploaderApi.Entity.Scholarship;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelHelper;
import com.moreOpp.dataUploader.UploaderApi.Service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ScholarshipController {
    @Autowired
    private ScholarshipService scholarshipService;


    @PostMapping("scholarship/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(ExcelHelper.checkExcelFileFormat(file)){
//            true
            this.scholarshipService.saveScholarship(file);
            return ResponseEntity.ok(Map.of("message","scholarship file uploaded successfully to database"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel files only!");

    }
    @GetMapping("/scholarships")
    public List<Scholarship> allScholarships(){
        return this.scholarshipService.getAllScholarships();
    }

    @DeleteMapping("/deleteAllScholarships")
    public ResponseEntity<?> deleteAlL(){
        try {
            this.scholarshipService.deleteAllScholarships();
            return ResponseEntity.ok(Map.of("Message","all scholarships deleted successfully"));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You are not authorized to perform this operation!!!");
        }
    }
}
