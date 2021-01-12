package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DayEleven {

	public static void main(String[] args) {
		DayEleven dayEleven = new DayEleven();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day11Input.txt";
		List<String> input = rdr.readFileString(path);
		dayEleven.taskOne(input);

	}

	public void taskOne(List<String> input) {
		int nrOfRow = input.size();
		int nrOfCol = input.get(0).length();
		String[][] grid = new String[nrOfRow][nrOfCol];
		for (int i = 0; i < nrOfRow; i++) {
			for (int j = 0; j < nrOfCol; j++) {
				grid[i][j] = input.get(i).substring(j, j + 1);
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Start state");
		System.out.println("");
		String[][] newGrid = new String[nrOfRow][nrOfCol];
		for (int i = 0; i < nrOfRow; i++) {
			for (int j = 0; j < nrOfCol; j++) {
				newGrid[i][j] = input.get(i).substring(j, j + 1);
			}
		}
		int nrOfChanges = 0;
		int nrOfIterations = 0;
		do {
			nrOfChanges = 0;
			for (int i = 0; i < nrOfRow; i++) {
				for (int j = 0; j < nrOfCol; j++) {
					grid[i][j] = newGrid[i][j];
				}
			}
			for (int i = 0; i < nrOfRow; i++) {
				for (int j = 0; j < nrOfCol; j++) {
					int nrOfFull = 0;
					int nrOfChecked = 0;
					for (int k = i - 1; k < i + 2; k++) {
						for (int m = j - 1; m < j + 2; m++) {
							if (k >= 0 && k < nrOfRow && m >= 0 && m < nrOfCol) {
								if (!(k == i && m == j)) {
									nrOfChecked++;
									//System.out.println("Checked k="+k+ "m="+m);
									if ("#".equals(grid[k][m])) {
										nrOfFull++;
									}
								}
							}
						}
					}
					//System.out.println(nrOfChecked);
					if ("L".equals(grid[i][j]) && nrOfFull == 0) {
						newGrid[i][j] = "#";
						nrOfChanges++;
					}
					if ("#".equals(grid[i][j]) && nrOfFull > 3) {
						newGrid[i][j] = "L";
						nrOfChanges++;
					}
				}
			}
			/*
			for (int i = 0; i < nrOfCol; i++) {
				for (int j = 0; j < nrOfRow; j++) {
					System.out.print(newGrid[i][j]);
				}
				System.out.println("");
			}
			System.out.println("");
			System.out.println("");
			*/
			nrOfIterations++;
		} while (nrOfChanges != 0);
		
		int nrOfOcc=0;
		for (int i = 0; i < nrOfRow; i++) {
			for (int j = 0; j < nrOfCol; j++) {
				if("#".equals(grid[i][j])) {
					nrOfOcc++;
				}
			}
		}
		System.out.println("Number of full chairs is "+nrOfOcc);
	
	}

}
