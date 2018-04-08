package excelPoi;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class WeiZHiExcel {
    public static void WeizhiTest(){
        Workbook   wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("weizhi");
        Row row =sheet.createRow(2);
       row.setHeightInPoints((short)30);
       createCell(wb,row,0,HorizontalAlignment.CENTER,VerticalAlignment.BOTTOM);
        createCell(wb,row,1,HorizontalAlignment.CENTER_SELECTION,VerticalAlignment.BOTTOM);
        createCell(wb, row, 2, HorizontalAlignment.FILL, VerticalAlignment.CENTER);
        createCell(wb, row, 3, HorizontalAlignment.GENERAL, VerticalAlignment.CENTER);
        createCell(wb, row, 4, HorizontalAlignment.JUSTIFY, VerticalAlignment.JUSTIFY);
        createCell(wb, row, 5, HorizontalAlignment.LEFT, VerticalAlignment.TOP);
        createCell(wb, row, 6, HorizontalAlignment.RIGHT, VerticalAlignment.TOP);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("WEIZHI.xlsx");
            wb.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Horizontal水平的Vertical垂直的队列
     * */
    private static void createCell(Workbook wb, Row row, int column, HorizontalAlignment halign, VerticalAlignment valign) {
        Cell cell=row.createCell(column);
        cell.setCellValue("Align It");
        CellStyle cellStyle=wb.createCellStyle();
        cellStyle.setAlignment(halign);
        cellStyle.setVerticalAlignment(valign);
        cell.setCellStyle(cellStyle);
    }

    public static void main(String[] args) {
        WeizhiTest();
    }

    @Test
    public void testReadExcel(){

        try {
            FileInputStream inputStream=new FileInputStream("wookbook.xlsx");
            Workbook workbook=new XSSFWorkbook(inputStream);
            DataFormatter dataFormatter=new DataFormatter();
            Sheet sheet=workbook.getSheetAt(0);
            Row row=sheet.getRow(0);
            for(Cell cell:row){
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");

                String text = dataFormatter.formatCellValue(cell);
                System.out.println(text);
//                switch (cell.getCellType()) {
//                    case CellType.STRING:
//                        System.out.println(cell.getRichStringCellValue().getString());
//                        break;
//                    case CellType.NUMERIC:
//                        if (DateUtil.isCellDateFormatted(cell)) {
//                            System.out.println(cell.getDateCellValue());
//                        } else {
//                            System.out.println(cell.getNumericCellValue());
//                        }
//                        break;
//                    case CellType.BOOLEAN:
//                        System.out.println(cell.getBooleanCellValue());
//                        break;
//                    case CellType.FORMULA:
//                        System.out.println(cell.getCellFormula());
//                        break;
//                    case CellType.BLANK:
//                        System.out.println();
//                        break;
//                    default:
//                        System.out.println();
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testextraction(){
        InputStream inp = null;
        try {
            inp = new FileInputStream("WEIZHI.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(inp);
////            ExcelExtractor extractor = new ExcelExtractor(wb);
//            extractor.setFormulasNotResults(true);
//            extractor.setIncludeSheetNames(false);
//            String text = extractor.getText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
