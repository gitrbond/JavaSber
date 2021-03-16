package ru.sber.reportGenerator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;


public class ExporterToExcelFormat {
    public static XSSFWorkbook ExportStringArrayToExcelFormat(String[][] stringArray) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        int rowCount = 0;

        for (Object[] aBook : stringArray) {
            Row row = sheet.createRow(rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                }
                else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
                columnCount++;
            }
            rowCount++;
        }
        return workbook;
        /*try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }*/
    }
}
