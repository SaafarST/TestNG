package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.plaf.PanelUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    // Order: 1. filePath, 2.Workbook, 3.Sheet, 4.Rows & Cols, 5.Cell (For each step we will create a method).
    //public static String projectPath = System.getProperty("user.dir");
    public static String projectPath = System.getProperty("user.dir");
    private static FileInputStream fileInputStream;
    private static Workbook workbook ;
    private static Sheet sheet;
    private static void getFilePath(String filepath){
        try {
            fileInputStream = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getSheet(String sheetName){
        sheet = workbook.getSheet(sheetName);
    }
    private static int rowCount(){
        return sheet.getPhysicalNumberOfRows();
    }
    private static int colsCount(){
       return sheet.getRow(0).getLastCellNum();
    }
    private static String getCell(int rowIndex, int columnIndex){
        return sheet.getRow(rowIndex).getCell(columnIndex).toString();
    }
    public static Object [][] readFromExcel(String filePath, String sheetName){
        getFilePath(filePath);
        getSheet(sheetName);
        int rows = rowCount();
        int columns = colsCount();
        Object[][] data = new Object[rows-1][columns];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i-1][j] = getCell(i, j);
            }
        }
        return data;
    }

}