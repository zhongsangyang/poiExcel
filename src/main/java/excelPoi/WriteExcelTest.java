package excelPoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class WriteExcelTest {
    public static void main(String[] args) {
        //oWorkbook wb=new HSSFWorkbook();r new XSSFWorkbook();
        Workbook wb=new XSSFWorkbook();
        FileOutputStream fileOutputStream=null;
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet1=wb.createSheet("new sheet1");
        Sheet sheet2=wb.createSheet("second sheet");
        Row row=sheet1.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue(1);
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);
        Row row2=sheet2.createRow(0);
        Cell cell12=row2.createCell(0);
        cell12.setCellValue(new Date());
        CellStyle cellStyle=wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell12=row2.createCell(1);
        cell12.setCellValue(new Date());
        cell12.setCellStyle(cellStyle);
        cell12=row2.createCell(2);
        cell12.setCellValue(Calendar.getInstance());
        cell12.setCellStyle(cellStyle);
        //        yyyy年MM月dd日 EEE HH:mm:ss

        String safeName= WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]");
        writeBook(wb,fileOutputStream,"wookbook.xlsx");
//        writeBook(wb,fileOutputStream,"workbook.xls");
//        writeBook(wb,fileOutputStream,"workbook.xlsx");

    }
    public static void writeBook(Workbook workbook, OutputStream outputStream,String name){
        try {

            outputStream = new FileOutputStream(name);
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

