package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Entity.Internship;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelToInternshipDb;
import com.moreOpp.dataUploader.UploaderApi.Repo.InternshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InternshipService {
    @Autowired
    private InternshipRepo internshipRepo;

    public void saveInternship(MultipartFile file) throws IOException {
        try {
            List<Internship> internships = ExcelToInternshipDb.
                    convertExcelToListOfInternships(file.getInputStream());
            this.internshipRepo.saveAll(internships);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
    public List<Internship> getAllInternships(){
        return  this.internshipRepo.findAll();
    }

    public void deleteAllInternships() {
        this.internshipRepo.deleteAll();
    }
}
