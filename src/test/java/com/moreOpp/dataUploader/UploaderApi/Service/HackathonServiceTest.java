package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Repo.HackathonRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HackathonServiceTest {

    @Autowired
    private HackathonRepo hackathonRepo;

    @Test
    void deleteAllHackathons() {
        this.hackathonRepo.deleteAll();
    }
}