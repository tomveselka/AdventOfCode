package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayFifteen {

	public static void main(String[] args) {
		DayFifteen dayFifteen = new DayFifteen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day15Input.txt";
		List<String> input = rdr.readFileString(path);
		String[] numbers=input.get(0).split(",");
		List<Integer> inputInt=new ArrayList<Integer>();
		for (int i=0;i<numbers.length;i++) {
			inputInt.add(Integer.parseInt(numbers[i]));
			//System.out.println(inputInt.get(i));
		}
		//dayFifteen.taskOne(inputInt);
		dayFifteen.taskTwo(inputInt);
		
	}
	
	public void taskOne(List<Integer> input) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> spokenNumbers=new ArrayList<Integer>();
		for (int i=0;i<input.size()-1;i++) {
			map.put(input.get(i), i+1);
			spokenNumbers.add(input.get(i));
		}
		spokenNumbers.add(input.get(input.size()-1));
		int turn=input.size()+1;
		while (turn<=2020) {
			int spokenNumbersSize=spokenNumbers.size();
			System.out.println("Last spoken number was "+spokenNumbers.get(spokenNumbersSize-1));
			if (!map.containsKey(spokenNumbers.get(spokenNumbersSize-1))) {
				spokenNumbers.add(0);
				map.put(spokenNumbers.get(spokenNumbers.size()-2), turn-1);
			}else {
				int lastSpokenNumber=spokenNumbers.get(spokenNumbersSize-1);
				int lastTime=map.get(lastSpokenNumber);
				System.out.println(lastSpokenNumber+" was previously spoken in turn "+lastTime);
				spokenNumbers.add(turn-1-lastTime);
				map.put(spokenNumbers.get(spokenNumbers.size()-2), turn-1);
				
			}
			
			turn++;
		}
		System.out.println("2020th number spoken was "+spokenNumbers.get(2019));
	}
	
	public void taskTwo(List<Integer> input) {
		System.out.println(input);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> spokenNumbers=new ArrayList<Integer>();
		for (int i=0;i<input.size()-1;i++) {
			map.put(input.get(i), i+1);
			spokenNumbers.add(input.get(i));
		}
		spokenNumbers.add(input.get(input.size()-1));
		int turn=input.size()+1;
		while (turn<=30000000) {
			int spokenNumbersSize=spokenNumbers.size();
			//System.out.println("Last spoken number was "+spokenNumbers.get(spokenNumbersSize-1));
			if (!map.containsKey(spokenNumbers.get(spokenNumbersSize-1))) {
				spokenNumbers.add(0);
				map.put(spokenNumbers.get(spokenNumbers.size()-2), turn-1);
			}else {
				int lastSpokenNumber=spokenNumbers.get(spokenNumbersSize-1);
				int lastTime=map.get(lastSpokenNumber);
				//System.out.println(lastSpokenNumber+" was previously spoken in turn "+lastTime);
				spokenNumbers.add(turn-1-lastTime);
				map.put(spokenNumbers.get(spokenNumbers.size()-2), turn-1);
				
			}
			
			turn++;
		}
		System.out.println("30000000th number spoken was "+spokenNumbers.get(30000000-1));
	}
	
	
	
}
