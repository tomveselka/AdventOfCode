package days;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DayThree {

	public static void main(String[] args) {
		DayThree dayThree = new DayThree();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day3Input.txt";
		List<String> input = rdr.readFileString(path);
		
		dayThree.taskOne(input);
		dayThree.taskTwo(input);
	}

	public void taskOne(List<String> rows) {
		int length = rows.get(0).length();
		System.out.println("Number of chars is: " + length);
		int pos = 0;
		int trees = 0;
		for (int i = 0; i < rows.size(); i++) {
			if ('#' == rows.get(i).charAt(pos)) {
				trees++;
			}
			pos = pos + 3;
			if (pos > length - 1) {
				pos = pos - length;
			}
		}
		System.out.println("Number of hit trees is " + trees);
	}

	public void taskTwo(List<String> rows) {
		int length = rows.get(0).length();
		System.out.println("Number of chars is: " + length);
		int pos = 0;
		int trees[]= {0,0,0,0,0};
		int right[] = { 1, 3, 5, 7, 1 };
		int down[] = { 1, 1, 1, 1, 2 };
		for (int j = 0; j < 5; j++) {
			pos=0;
			for (int i = 0; i < rows.size(); i=i+down[j]) {
				if ('#' == rows.get(i).charAt(pos)) {
					trees[j]++;
				}
				pos = pos + right[j];
				if (pos > length - 1) {
					pos = pos - length;
				}
			}
		}
		long result=1;
		for (int i=0;i<5;i++) {
			result=result*trees[i];
			System.out.println("Number of trees hit in "+i+".scenario is "+trees[i]);
			System.out.println("Result so far is: "+result);
		}
		
		System.out.println("Result is " + result);
	}

}
