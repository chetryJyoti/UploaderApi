package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Entity.Hackathon;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelToHackathonDb;
import com.moreOpp.dataUploader.UploaderApi.Repo.HackathonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HackathonService {

    @Autowired
    private HackathonRepo hackathonRepo;

    public void saveHackathons(MultipartFile file) throws IOException {
        try {
            List<Hackathon> hackathons = ExcelToHackathonDb.convertExceToListOfHackathon(file.getInputStream());
            this.hackathonRepo.saveAll(hackathons);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
    public List<Hackathon> getAllHackathons(){
        return  this.hackathonRepo.findAll();
    }

    public void deleteAllHackathons(){
        this.hackathonRepo.deleteAll();
    }
}
