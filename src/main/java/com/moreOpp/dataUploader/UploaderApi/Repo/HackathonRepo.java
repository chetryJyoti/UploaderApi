package com.moreOpp.dataUploader.UploaderApi.Repo;

import com.moreOpp.dataUploader.UploaderApi.Entity.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackathonRepo extends JpaRepository<Hackathon,Long> {
}
