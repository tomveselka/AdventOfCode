package days;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DayTwo {

	public static void main(String[] args) {

		DayTwo dayTwo = new DayTwo();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day2Input.txt";
		List<String> input = rdr.readFileString(path);
		List<PasswordRows> passwords = new ArrayList<PasswordRows>();
		for (int i=0;i<input.size();i++) {
			String[] firstSplit=input.get(i).split(" ");
			String[] minMax=firstSplit[0].split("-");
			int min=Integer.parseInt(minMax[0]);
			int max=Integer.parseInt(minMax[1]);
			String letter=firstSplit[1].replace(":", "");
			String password=firstSplit[2];
			passwords.add(new PasswordRows(min, max, letter, password));
			
		}
		
		
		
		dayTwo.taskOne(passwords);
		dayTwo.taskTwo(passwords);
		
	}

	public void taskOne(List<PasswordRows> passwords) {
		int numberOfChar=0;
		int numberOfValid=0;
		for (PasswordRows row : passwords) {
			String password=row.getPassword();
			int count = StringUtils.countMatches(password, row.getLetter());
			if (count>=row.getMinimum()&&count<=row.getMaximum()) {
				numberOfValid++;
			}
			
		}
		System.out.println("Task one: Number of valid passwords is: "+numberOfValid);
	}
	
	public void taskTwo(List<PasswordRows> passwords) {

		int numberOfValid=0;
		for (PasswordRows row : passwords) {
			String password=row.getPassword();
			char firstChar=password.charAt(row.getMinimum()-1);
			char secondChar=password.charAt(row.getMaximum()-1);
			if (row.getLetter().equals(String.valueOf(firstChar))&&!row.getLetter().equals(String.valueOf(secondChar))) {
				numberOfValid++;
			}else if(!row.getLetter().equals(String.valueOf(firstChar))&&row.getLetter().equals(String.valueOf(secondChar))) {
				numberOfValid++;
			}
			
		}
		System.out.println("Task two: Number of valid passwords is: "+numberOfValid);
	}

}
