package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

public class DaySeventeen {
	public static void main(String[] args) {
		DaySeventeen daySeventeen = new DaySeventeen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day17InputTest.txt";
		List<String> input = rdr.readFileString(path);

		//daySeventeen.taskOne(input);
		// daySixteen.taskTwo(inputInt);

	}
/*
	public void taskOne(List<String> input) {
		// HashMap<List<Integer>, String> grid =new HashMap<List<Integer>, String>();
		String[][][] grid = new String[input.size()][input.size()][input.size()];
		HashMap <Triple<Integer, Integer, Integer>, String> gridMap= new HashMap<Triple<Integer, Integer, Integer>, String>();
		// coordinates <x,y,z>
		// x rows, y columns
		// base plane
		for (int x = 0; x < input.size(); x++) {
			for (int y = 0; y < input.size(); y++) {
				//grid[x][y][0] = input.get(y).substring(x, x + 1);
				Triple<Integer, String, String> triplet 
	            = new Triple<Integer, String, String>(Integer.valueOf(1),  
	                                "GeeksforGeeks", "A computer portal");
				gridMap.put(Triple.with(0,0,0),input.get(y).substring(x, x + 1));
			}
		}
		// remaining planes
		for (int x = 0; x < input.size(); x++) {
			for (int y = 0; y < input.size(); y++) {
				for (int z = 0; z < input.size(); z++) {
					grid[x][y][z] = ".";
				}
			}
		}

		String[][][] newGrid = new String[input.size()][input.size()][input.size()];
		
		for (int cycle = 0; cycle < 6; cycle++) {
			System.out.println("Cycle nr "+cycle);
			// check
			for (int x = 0; x < input.size(); x++) {
				for (int y = 0; y < input.size(); y++) {
					for (int z = 0; z < input.size(); z++) {
						String state = grid[x][y][z];
						int countOfActive = 0;
						int countOfInactive = 0;
						// Checking 26 coordinates around
						for (int x1 = x - 1; x1 < 2; x++) {
							for (int y1 = y - 1; y1 < 2; y1++) {
								for (int z1 = z - 1; z1 < 2; z1++) {
									if (x1 >= 0 && y1 >= 0 && z1 >= 0 && x1 < input.size() && y1 < input.size()
											&& z1 < input.size() && (x1 == x && y1 == y && z1 == z)) {
										if ("#".equals(grid[x1][y1][z1])) {
											countOfActive++;
										} else {
											countOfInactive++;
										}
									}
								}
							}
						}
						// end of coord checking
						if ((countOfActive == 2 || countOfActive == 3) && "#".equals(grid[x][y][z])) {
							newGrid[x][y][z] = ".";
						} else if ((countOfActive == 3) && ".".equals(grid[x][y][z])) {
							newGrid[x][y][z] = "#";
						} else {
							newGrid[x][y][z] = grid[x][y][z];
						}
					}
				}
			}
			// updating grid
			for (int x = 0; x < input.size(); x++) {
				for (int y = 0; y < input.size(); y++) {
					for (int z = 0; z < input.size(); z++) {
						grid[x][y][z] = newGrid[x][y][z];
					}
				}
			}
		}
		
		int finalCount=0;
		for (int x = 0; x < input.size(); x++) {
			for (int y = 0; y < input.size(); y++) {
				for (int z = 0; z < input.size(); z++) {
					if ("#".equals(grid[x][y][z])){
						finalCount++;
					}
				}
			}
		}
		System.out.println("Number of active cubes after 6  cycles is "+finalCount);

	}*/
}
