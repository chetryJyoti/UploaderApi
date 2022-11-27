package com.moreOpp.dataUploader.UploaderApi.Controller;

import com.moreOpp.dataUploader.UploaderApi.Entity.Book;
import com.moreOpp.dataUploader.UploaderApi.Helper.ExcelHelper;
import com.moreOpp.dataUploader.UploaderApi.Service.BookService;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        if(ExcelHelper.checkExcelFileFormat(file)){
            //true
            this.bookService.save(file);
            return  ResponseEntity.ok(Map.of("message","file upload and saved to database"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel files only");
    }
    @GetMapping("books")
    public List<Book> allBooks(){
        return this.bookService.getAllBooks();
    }

}
