package com.moreOpp.dataUploader.UploaderApi.Repo;

import com.moreOpp.dataUploader.UploaderApi.Entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepo extends JpaRepository<Scholarship,Long> {
}
