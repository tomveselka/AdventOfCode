package days;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DayOne {

	public static void main(String[] args) {
		DayOne dayOne = new DayOne();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day1Input.txt";
		List<Integer> input = rdr.readFileInt(path);
		
		dayOne.taskOne(input);
		dayOne.taskTwo(input);

	}

	public void taskOne(List<Integer> expenses) {
		int targetValue = 2020;
		int size = expenses.size();
		int midPoint = 0;

		boolean resultFound = false;
		Collections.sort(expenses);
		while (!resultFound) {
			size = expenses.size();
			midPoint = (int) Math.floor(size / 2);
			System.out.println("size: " + size + "midPoint: " + midPoint);
			if (targetValue > expenses.get(0) + expenses.get(midPoint)) {
				for (int i = midPoint; i < size; i++) {
					if (targetValue == expenses.get(0) + expenses.get(i)) {
						System.out.println("Resulting numbers are: x=" + expenses.get(0) + " y=" + expenses.get(i)
								+ "x*y=" + expenses.get(0) * expenses.get(i));
						resultFound = true;
					}
				}
			} else if (targetValue < expenses.get(0) + expenses.get(midPoint)) {
				for (int i = 1; i < midPoint; i++) {
					if (targetValue == expenses.get(0) + expenses.get(i)) {
						System.out.println("Resulting numbers are: x=" + expenses.get(0) + " y=" + expenses.get(i)
								+ "x*y=" + expenses.get(0) * expenses.get(i));
						resultFound = true;
					}
				}
			} else {
				System.out.println("Resulting numbers are: x=" + expenses.get(0) + " y=" + expenses.get(midPoint)
						+ "x*y=" + expenses.get(0) * expenses.get(midPoint));
				resultFound = true;
			}
			expenses.remove(0);
		}
	}

	public  void taskTwo(List<Integer> expenses) {
		int targetValue = 2020;
		int sum = 0;
		int size = expenses.size();
		int a = 0;
		int b = 0;
		int midPoint = 0;

		boolean resultFound = false;
		Collections.sort(expenses);
		// System.out.println("size: "+size+"firstnumber="+expenses.get(0));

		while (!resultFound) {
			a = expenses.get(0);
			size = expenses.size();

			System.out.println("a=" + a + "b=" + b + "size: " + size + "midPoint: " + midPoint);

			for (int j = 1; j < size - 1; j++) {
				b = expenses.get(j);
				sum = a + b;

				for (int i = j + 1; i < size; i++) {
					if (targetValue == sum + expenses.get(i)) {
						System.out.println(
								"a=" + a + "b=" + b + "c=" + expenses.get(i) + "a*b*c=" + a * b * expenses.get(i));
						resultFound = true;
					}
				}

			}
			expenses.remove(0);
		}
	}

}
