package Scraaay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class scray_main {
	
	public static void main(String[] args) throws IOException {
		
		Scayping scr = new Scayping();
		Excel_file excel = new Excel_file();
		
		ArrayList<ArrayList<String>> list = scr.Scrayping();
		int size = list.get(0).size();
		excel.write(list,size);
		
	}

}
