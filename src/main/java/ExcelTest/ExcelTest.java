package ExcelTest;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        //1. 엑셀 파일 읽기 FileInputStream
        FileInputStream file = new FileInputStream(new File("Test.xlsx"));
        //2.FileInputStream -> Workbook 엑셀 읽을 수 있게 생성
        Workbook workbook = WorkbookFactory.create(file);
        //3.Excel -> sheet
        Sheet sheet = workbook.getSheetAt(0);  // 첫번째 행
        //4. sheet -> row
        for(Row r : sheet){
            //5. row -> cell
            for(Cell c : r){
                if(c.getCellType() == CellType.NUMERIC){  // 숫자이면,
                    // 데이터가 날짜이면
                    if(DateUtil.isCellDateFormatted(c)){
                        //날짜
                        Date d = c.getDateCellValue();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String date = dateFormat.format(d);
                        System.out.print(date+"\t");
                    }
                    else{
                        double number = c.getNumericCellValue();  // 실수
                        //정수
                        if(number == Math.floor(number)) {
                            System.out.print(((int)number)+"\t");  // 숫자
                        }
                        //실수
                        else{
                            System.out.print(number+"\t");
                        }
                    }
                }
                else if(c.getCellType() == CellType.STRING){  // 문자열
                    System.out.print(c.getStringCellValue()+"\t");
                }
                else if(c.getCellType() == CellType.BOOLEAN){  // 논리값
                    System.out.print(c.getBooleanCellValue()+"\t");
                }
                else if(c.getCellType() == CellType.FORMULA){ // 수식 데이터
                    FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                    Date d =evaluator.evaluateInCell(c).getDateCellValue();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(d);
                    System.out.print(date+"\t");
                }
                else if(c.getCellType() == CellType.BLANK){  // 비어있는 경우
                    System.out.print("\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
