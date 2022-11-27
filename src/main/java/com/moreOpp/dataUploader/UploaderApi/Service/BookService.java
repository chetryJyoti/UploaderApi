package com.moreOpp.dataUploader.UploaderApi.Service;

import com.moreOpp.dataUploader.UploaderApi.Entity.Book;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelHelper;
import com.moreOpp.dataUploader.UploaderApi.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void save(MultipartFile file) throws IOException {
        try {
            List<Book> books = ExcelHelper.convertExceToListOfBook(file.getInputStream());
            this.bookRepo.saveAll(books);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
    public List<Book> getAllBooks(){
        return  this.bookRepo.findAll();
    }
}
