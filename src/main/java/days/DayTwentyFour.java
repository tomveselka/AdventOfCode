package days;

import java.util.ArrayList;
import java.util.List;

public class DayTwentyFour {
	public static void main(String[] args) {
		DayTwentyFour dayTwentyFour = new DayTwentyFour();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day24Input.txt";
		List<String> input = rdr.readFileString(path);
		dayTwentyFour.taskOne(input);
	}

	public void taskOne(List<String> input) {
		List<DayTwentyFourCoord> finalCoord = new ArrayList<DayTwentyFourCoord>();
		for (int i = 0; i < input.size(); i++) {
			List<String> directions = divideDirections(input.get(i));
			DayTwentyFourCoord coord = new DayTwentyFourCoord(0, 0, 0);
			for (int j = 0; j < directions.size(); j++) {
				if ("w".equals(directions.get(j))) {
					coord.setX(coord.getX() - 1);
					coord.setY(coord.getY() + 1);
				} else if ("e".equals(directions.get(j))) {
					coord.setX(coord.getX() + 1);
					coord.setY(coord.getY() - 1);
				} else if ("nw".equals(directions.get(j))) {
					coord.setY(coord.getY() + 1);
					coord.setZ(coord.getZ() - 1);
				} else if ("ne".equals(directions.get(j))) {
					coord.setX(coord.getX() + 1);
					coord.setZ(coord.getZ() - 1);
				} else if ("sw".equals(directions.get(j))) {
					coord.setX(coord.getX() - 1);
					coord.setZ(coord.getZ() + 1);
				} else if ("se".equals(directions.get(j))) {
					coord.setY(coord.getY() - 1);
					coord.setZ(coord.getZ() + 1);
				}
			}
			boolean matchFound=false;
			if (finalCoord.size()!=0) {				
				for (DayTwentyFourCoord crd:finalCoord) {
					if (coord.getX()==crd.getX()&&coord.getY()==crd.getY()&&coord.getZ()==crd.getZ()) {
						matchFound=true;
						finalCoord.remove(crd);
						break;
					}
				}
			}
			if (!matchFound) {
				finalCoord.add(coord);
			}
		}
		System.out.println("Number of black tiles is: "+finalCoord.size());
	}

	public List<String> divideDirections(String line) {
		List<String> directions = new ArrayList<String>();
		int i = 0;
		StringBuilder str = new StringBuilder();
		while (i < line.length()) {
			str.append(line.substring(i, i + 1));
			if (str.length() == 1 && ("w".equals(str.toString()) || "e".equals(str.toString()))) {
				directions.add(str.toString());
				str.setLength(0);
			} else if (str.length() == 2) {
				directions.add(str.toString());
				str.setLength(0);
			}
			i++;
		}
		return directions;
	}
}
