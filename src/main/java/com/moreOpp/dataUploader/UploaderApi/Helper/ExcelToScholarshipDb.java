package com.moreOpp.dataUploader.UploaderApi.Helper;

import com.moreOpp.dataUploader.UploaderApi.Entity.Internship;
import com.moreOpp.dataUploader.UploaderApi.Entity.Scholarship;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelToScholarshipDb {
    public static List<Scholarship> convertExcelToListOfScholarships(InputStream is){
        List<Scholarship> list  = new ArrayList<>();

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
                Scholarship scholarship = new Scholarship();
                while(cells.hasNext()){
                    Cell cell = cells.next();
                    switch (cid){
                        case 0:
                            scholarship.setTitle(cell.getStringCellValue());
                            break;
                        case 1:
                            scholarship.setDescription(cell.getStringCellValue());
                            break;
                        case 2:
                            scholarship.setLinkToRegister(cell.getStringCellValue());
                            break;
                        case 3:
                            scholarship.setCreatedOn(new Date());
                            break;
                        case 4:
                            scholarship.setLastDayToRegister(cell.getStringCellValue());
                            break;
                        case 5:
                            scholarship.setEligibility(cell.getStringCellValue());
                            break;
                        case 6:
                            scholarship.setBannerImgLink(cell.getStringCellValue());
                            break;
                        case 7:
                            scholarship.setActive(true);
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(scholarship);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }
}
