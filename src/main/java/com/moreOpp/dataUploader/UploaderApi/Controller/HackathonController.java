package com.moreOpp.dataUploader.UploaderApi.Controller;

import com.moreOpp.dataUploader.UploaderApi.Entity.Hackathon;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelHelper;
import com.moreOpp.dataUploader.UploaderApi.Service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class HackathonController {
    @Autowired
    private HackathonService hackathonService;
    @PostMapping("/hackathon/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(ExcelHelper.checkExcelFileFormat(file)){
            //true
            this.hackathonService.saveHackathons(file);
            return  ResponseEntity.ok(Map.of("message","file upload and saved to database"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel files only");
    }
    @GetMapping("/hackathons")
    public List<Hackathon> allHackathons(){
        return this.hackathonService.getAllHackathons();
    }

    @DeleteMapping("/deleteAllHackathons")
    public ResponseEntity<?> deleteAlL(){
        try {
            this.hackathonService.deleteAllHackathons();
            return ResponseEntity.ok(Map.of("Message","all hackathons deleted successfully"));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You are not authorized to perform this operation!!!");
        }
    }
}
