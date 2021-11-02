import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {

    List cuvinte = new ArrayList();

    int x = 0;



    FileInputStream file = null;

   {
        try {
            file = new FileInputStream(new File("/home/bvoicu/Documents/SI/Java/Hangman/src/file.xls"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        //Create Workbook instance holding reference to .xlsx file
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Get first/desired sheet from the workbook
        HSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet)     //iteration over row using for each loop
        {
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case STRING:    //field that represents string cell type
                        //getting the value of the cell as a string
                        cuvinte.add(cell.getStringCellValue());
                        break;
                    case BLANK:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + formulaEvaluator.evaluateInCell(cell).getCellType());
                }
            }
        }
    }



    String returnItem(int i){
        String incercare = (String) cuvinte.get(i);
        return incercare;
    }

    int returnSize(){
        x = cuvinte.size();
        return x;
    }



}


