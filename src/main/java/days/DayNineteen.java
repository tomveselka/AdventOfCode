package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayNineteen {

	public static void main(String[] args) {
		DayNineteen dayNineteen = new DayNineteen();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day11InputTest.txt";
		List<String> input = rdr.readFileString(path);
		dayNineteen.taskOne(input);

	}
	
	public void taskOne(List<String> input) {
		
		HashMap <String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
		for (int i=0; i<input.size();i++) {
			String line=input.get(i);
			String[] firstSplit=line.split(":");
			String key=firstSplit[0];
			//List<String> options=splitLine(line);
		}
	}
	/*
	public List<String> splitLine(String line){
		String[] secondSplit=line.split("|");
		String regex = "[0-9]+";
		if (secondSplit.length==1&&!secondSplit[0].matches(regex)) {
			List<List<String>> list = new ArrayList<List<String>>();
			List<String> list2=new ArrayList<String>();
			list2.add(secondSplit[0].replace("\"", ""));
			list.add(list2);
			map.put(Integer.getInteger((firstSplit[0])), list);
		}
	}*/

}
