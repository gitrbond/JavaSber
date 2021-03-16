package ru.sber.reportGenerator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.util.List;

public class ReportExcelGenerator<T> implements ReportGenerator<T> {
    @Override
    public Report generate(List<T> entities) throws IllegalAccessException {
        Class<?> clazz = entities.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[][] stringArray = new String[entities.size() + 1][fields.length];
        //названия полей
        int row = 0;
        for (Field field : fields) {
            stringArray[0][row] = field.getName();
            row++;
        }
        //данные об entities
        row = 1;
        for (T elem : entities) {
            int column = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    stringArray[row][column] = field.get(elem).toString();
                    column++;
                }
                catch (IllegalAccessException e) {
                    throw new RuntimeException("Could not access entity field", e);
                }
            }
            row++;
        }

        for (String[] strings1 : stringArray) {
            for (String str : strings1) {
                System.out.print(str + " ");
            }
            System.out.println("\n");
        }

        return new ReportExcel(stringArray);
    }
}
