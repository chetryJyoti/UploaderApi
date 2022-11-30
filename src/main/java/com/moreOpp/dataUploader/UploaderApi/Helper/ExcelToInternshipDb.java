package com.moreOpp.dataUploader.UploaderApi.Helper;

import com.moreOpp.dataUploader.UploaderApi.Entity.Hackathon;
import com.moreOpp.dataUploader.UploaderApi.Entity.Internship;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelToInternshipDb {

    public static List<Internship> convertExcelToListOfInternships(InputStream is){
        List<Internship> list  = new ArrayList<>();

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
                Internship internship = new Internship();
                while(cells.hasNext()){
                    Cell cell = cells.next();
                    switch (cid){
                        case 0:
                            internship.setCompanyName(cell.getStringCellValue());
                            break;
                        case 1:
                            internship.setInternshipTitle(cell.getStringCellValue());
                            break;
                        case 2:
                            internship.setActive(true);
                            break;
                        case 3:
                             internship.setWorkLocation(cell.getStringCellValue());
                            break;
                        case 4:
                            internship.setStipend(cell.getStringCellValue());
                            break;
                        case 5:
                            internship.setDescription(cell.getStringCellValue());
                            break;
                        case 6:
                            internship.setLinkToRegister(cell.getStringCellValue());
                            break;
                        case 7:
                            internship.setCreatedOn(new Date());
                            break;
                        case 8:
                            internship.setEligibility(cell.getStringCellValue());
                            break;
                        case 9:
                            internship.setBannerImgLink(cell.getStringCellValue());
                            break;
                        case 10:
                            internship.setLastDayToRegister(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(internship);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }

}
