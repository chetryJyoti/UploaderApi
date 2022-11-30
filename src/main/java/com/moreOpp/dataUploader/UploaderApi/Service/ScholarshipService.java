package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Entity.Scholarship;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelToScholarshipDb;
import com.moreOpp.dataUploader.UploaderApi.Repo.ScholarshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ScholarshipService {
    @Autowired
    private ScholarshipRepo scholarshipRepo;

    public void saveScholarship(MultipartFile file) throws IOException {
        try {
            List<Scholarship> scholarships = ExcelToScholarshipDb.
                    convertExcelToListOfScholarships(file.getInputStream());
            this.scholarshipRepo.saveAll(scholarships);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
    public List<Scholarship> getAllScholarships(){
        return  this.scholarshipRepo.findAll();
    }

    public void deleteAllScholarships() {
        this.scholarshipRepo.deleteAll();
    }
}
