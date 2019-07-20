package Scraaay;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.*;
import org.apache.poi.xssf.usermodel.*;

public class Excel_file {
	
	//エクセルファイルを置いているフォルダー
	private final String INPUT_DIR = "エクセルファイルが入っている場所を教えて上げる 例） user/desktop...";
	private Workbook wb = null;
	private FileOutputStream out = null;
			
	public void write(ArrayList<ArrayList<String>> lists,int size) throws IOException {
        FileInputStream in  = new FileInputStream(this.INPUT_DIR + "test.xlsx");
        try {
        	this.wb = WorkbookFactory.create(in);
        	Sheet sheet1 = this.wb.getSheet("Sheet1");
        	for(int i = 0; i < size; i++){
        		Row row = sheet1.createRow(i);
        		Cell cell_n = row.createCell(0); //元々値が入っていないとバグる。
        		Cell cell_p = row.createCell(1);
        		//取得したセルにセットする値を指定
        		cell_p.setCellValue(lists.get(1).get(i));
        		cell_n.setCellValue(lists.get(0).get(i));
           }
        }catch(Exception e1){
        	e1.printStackTrace();
        }
        	try {
    	    // 変更するエクセルファイルを指定
    	    this.out = new FileOutputStream(this.INPUT_DIR + "test.xlsx");
    	    // 書き込み
    	    wb.write(out);
    	}catch(Exception e){
    		e.printStackTrace();
    	} finally{
    		 this.out.close();
    		 this.wb.close();	 
    	}
	}
}
