package com.moreOpp.dataUploader.UploaderApi.Repo;

import com.moreOpp.dataUploader.UploaderApi.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
