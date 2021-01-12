package days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwelve {

	public static void main(String[] args) {
		DayTwelve dayTwelve = new DayTwelve();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day12Input.txt";
		List<String> input = rdr.readFileString(path);
		
		//dayTwelve.taskOne(input);
		dayTwelve.taskTwo(input);
	}
	
	public void taskOne(List<String> input) {
		String hdg="E";
		int hdgNr=90;
		Map<Integer, String> compass = new HashMap<Integer, String>();
		compass.put(0,"N");
		compass.put(90,"E");
		compass.put(180,"S");
		compass.put(270,"W");
		//ease is positive, west is negative, start is zero
		int eastDis=0;
		//north is positive, south is negative, start is zero
		int northDis=0;
		for (int i=0;i<input.size();i++) {
			String instruction=input.get(i);
			System.out.println(instruction);
			if ("R".equals(instruction.substring(0, 1))){
				hdgNr=calcHeading(hdgNr,Integer.parseInt(instruction.substring(1)));
				hdg=compass.get(hdgNr);
			}else if ("L".equals(instruction.substring(0, 1))){
				hdgNr=calcHeading(hdgNr,Integer.parseInt(instruction.substring(1))*-1);
				hdg=compass.get(hdgNr);
			}
			
			//System.out.println(hdg);
			if ("F".equals(instruction.substring(0, 1))){
				if ("N".equals(hdg)) {
					northDis=northDis+Integer.parseInt(instruction.substring(1));;
				}else if ("S".equals(hdg)) {
					northDis=northDis-Integer.parseInt(instruction.substring(1));;
				}
				else if ("E".equals(hdg)) {
					eastDis=eastDis+Integer.parseInt(instruction.substring(1));;
				}else if ("W".equals(hdg)) {
					eastDis=eastDis-Integer.parseInt(instruction.substring(1));;
				}
			}
			
			if ("N".equals(instruction.substring(0, 1))) {
				northDis=northDis+Integer.parseInt(instruction.substring(1));;
			}else if ("S".equals(instruction.substring(0, 1))) {
				northDis=northDis-Integer.parseInt(instruction.substring(1));;
			}
			else if ("E".equals(instruction.substring(0, 1))) {
				eastDis=eastDis+Integer.parseInt(instruction.substring(1));;
			}else if ("W".equals(instruction.substring(0, 1))) {
				eastDis=eastDis-Integer.parseInt(instruction.substring(1));;
			}
			System.out.println("East/West position is "+eastDis+" and North/West position is "+northDis+" Heading is "+hdg);
		}
		
		System.out.println("East/West position is "+eastDis+" and North/West position is "+northDis);
		System.out.println("Result Manhattan distance is "+(Math.abs(eastDis)+Math.abs(northDis)));
	}
	
	public int calcHeading(int current, int change) {
		//System.out.println("Current hdg is"+current+ " change is "+change);
		int newHdg=0;
		if (current+change>360) {
			newHdg=current+change-360;
		}else if (current+change<0){
			newHdg=360+current+change;
		}else {
			newHdg=current+change;
		}
		if (newHdg==360) {
			newHdg=0;
		}
		//System.out.println(newHdg);
		return Math.abs(newHdg);
	}
	
	public void taskTwo(List<String> input) {
		int hdgNr=90;
		Map<Integer, String> compass = new HashMap<Integer, String>();
		compass.put(0,"N");
		compass.put(90,"E");
		compass.put(180,"S");
		compass.put(270,"W");
		//SHIP DISTANCE
		int[] ship = {0,0};
		//first is east/vest, second is north/south
		//ease is positive, west is negative, start is zero
		//north is positive, south is negative, start is zero
		
		//WAYPOINT
		int[] vector = {10,1};
		//first is east/vest, second is north/south
		//north is positive, south is negative, start is zero
		//ease is positive, west is negative, start is zero

		for (int i=0;i<input.size();i++) {
			String instruction=input.get(i);
			System.out.println(instruction);
			if ("R".equals(instruction.substring(0, 1))){
				vector=rotateVector(vector,360-Integer.parseInt(instruction.substring(1)));
			}else if ("L".equals(instruction.substring(0, 1))){
				vector=rotateVector(vector,Integer.parseInt(instruction.substring(1)));
			}
			
			//System.out.println(hdg);
			if ("F".equals(instruction.substring(0, 1))){
				int speed=Integer.parseInt(instruction.substring(1));
				ship[0]=ship[0]+vector[0]*speed;
				ship[1]=ship[1]+vector[1]*speed;
			}
			
			if ("N".equals(instruction.substring(0, 1))) {
				vector[1]=vector[1]+Integer.parseInt(instruction.substring(1));;
			}else if ("S".equals(instruction.substring(0, 1))) {
				vector[1]=vector[1]-Integer.parseInt(instruction.substring(1));;
			}
			else if ("E".equals(instruction.substring(0, 1))) {
				vector[0]=vector[0]+Integer.parseInt(instruction.substring(1));;
			}else if ("W".equals(instruction.substring(0, 1))) {
				vector[0]=vector[0]-Integer.parseInt(instruction.substring(1));;
			}
			System.out.println("Ship:");
			System.out.println("East/West position is "+ship[0]+" and North/West position is "+ship[1]);
			System.out.println("Vector:");
			System.out.println("East/West position is "+vector[0]+" and North/West position is "+vector[1]);
		}
		
		System.out.println("East/West position is "+ship[0]+" and North/West position is "+ship[1]);
		System.out.println("Result Manhattan distance is "+(Math.abs(ship[0])+Math.abs(ship[1])));
	}

	public int[] rotateVector(int[] vector, int change) {
		int[] newVector= new int[2];
		int rot90[][]= {{0, -1}, {1, 0}};
		int rot180[][]= {{-1, 0}, {0, -1}};
		int rot270[][]= {{0, 1}, {-1, 0}};
		if (90==change) {
			newVector[0]= rot90[0][0]*vector[0]+rot90[0][1]*vector[1];
			newVector[1]= rot90[1][0]*vector[0]+rot90[1][1]*vector[1];
		}
		if (180==change) {
			newVector[0]= rot180[0][0]*vector[0]+rot180[0][1]*vector[1];
			newVector[1]= rot180[1][0]*vector[0]+rot180[1][1]*vector[1];
		}
		if (270==change) {
			newVector[0]= rot270[0][0]*vector[0]+rot270[0][1]*vector[1];
			newVector[1]= rot270[1][0]*vector[0]+rot270[1][1]*vector[1];
		}
		
		return newVector;
	}
}
