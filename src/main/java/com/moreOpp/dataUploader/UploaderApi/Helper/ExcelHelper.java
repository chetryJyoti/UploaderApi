package com.moreOpp.dataUploader.UploaderApi.Helper;

import com.moreOpp.dataUploader.UploaderApi.Entity.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static boolean checkExcelFileFormat(MultipartFile file){

        //checks if the fileformat is xl or not
        String contentType = file.getContentType();
        if(contentType.equals( "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }else return false;
    }

    //converts excel to list

    public static List<Book> convertExceToListOfBook(InputStream is){
        List<Book> list  = new ArrayList<>();

        try {
             XSSFWorkbook workbook = new XSSFWorkbook(is);

             //here data is the sheet name in our xl sheet
             XSSFSheet sheet = workbook.getSheet("Sheet");

             int rowNumber = 0;
             Iterator<Row> iterator = sheet.iterator();

             while(iterator.hasNext()){
                 Row row = iterator.next();
                 if(rowNumber==0){
                     rowNumber++;
                     continue;
                 }

                 Iterator<Cell> cells = row.iterator();
                 int cid=0;
                 Book book = new Book();

                 while(cells.hasNext()){
                     Cell cell = cells.next();
                     switch (cid){
                         case 0:
                             book.setBookId((int)cell.getNumericCellValue());
                             break;
                         case 1:
                             book.setTitle(cell.getStringCellValue());
                             break;
                         case 2:
                             book.setPrice(cell.getStringCellValue());
                             break;
                         case 3:
                             book.setAvailability(cell.getStringCellValue());
                             break;
                         default:
                             break;
                     }
                     cid++;
                 }
                 list.add(book);
             }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }


}
