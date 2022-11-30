package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Repo.InternshipRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InternshipServiceTest {

    @Autowired
    private  InternshipRepo internshipRepo;

    @Test
    void deleteAllInternships() {
        this.internshipRepo.deleteAll();
    }
}