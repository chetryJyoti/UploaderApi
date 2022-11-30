package com.moreOpp.dataUploader.UploaderApi.Helper;

import com.moreOpp.dataUploader.UploaderApi.Entity.Hackathon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;

public class ExcelToHackathonDb {
    public static List<Hackathon> convertExceToListOfHackathon(InputStream is){
        List<Hackathon> list  = new ArrayList<>();

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
                Hackathon hackathon = new Hackathon();
                while(cells.hasNext()){
                    Cell cell = cells.next();
                    switch (cid){
                        case 0:
                            hackathon.setTitle(cell.getStringCellValue());
                            break;
                        case 1:
                            hackathon.setDescription(cell.getStringCellValue());
                            break;
                        case 2:
                            hackathon.setLinkToRegister(cell.getStringCellValue());
                            break;
                        case 3:
                            hackathon.setLastDayToRegister(cell.getStringCellValue());
                            break;
                        case 4:
                            hackathon.setEligibility(cell.getStringCellValue());
                            break;
                        case 5:
                            hackathon.setActive(true);
                            break;
                        case 6:
                            hackathon.setBannerImgLink(cell.getStringCellValue());
                            break;
                        case 7:
                            hackathon.setCreatedOn(new Date());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(hackathon);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }

}
