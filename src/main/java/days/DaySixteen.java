package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySixteen {
	public static void main(String[] args) {
		DaySixteen daySixteen = new DaySixteen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day16Input.txt";
		List<String> input = rdr.readFileString(path);

		daySixteen.taskOne(input);
		//daySixteen.taskTwo(inputInt);
		
	}
	
	public void taskOne(List<String> input) {
		int i=0;
		List<Integer> validNumbers=new ArrayList<Integer>();
		while(!"".equals(input.get(i))) {
			System.out.println(input.get(i));
			String[] row=input.get(i).replace(" ", "").split(":");
			String[] intervalsString=row[1].split("or");
			String[] firstHalf=intervalsString[0].split("-");
			String[] secondHalf=intervalsString[1].split("-");
			//System.out.println(firstHalf[0]+" "+firstHalf[1]);
			//System.out.println(secondHalf[0]+" "+secondHalf[1]);
			int firstHalfLowEnd =Integer.parseInt(firstHalf[0]);
			int firstHalfHighEnd =Integer.parseInt(firstHalf[1]);	
			int secondHalfLowEnd =Integer.parseInt(secondHalf[0]);
			int secondHalfHighEnd =Integer.parseInt(secondHalf[1]);	
			for (int j=0; j<=firstHalfHighEnd-firstHalfLowEnd;j++) {
				int number=firstHalfLowEnd+j;
				if (!validNumbers.contains(number)) {
				validNumbers.add(number);
				}
			}
			for (int k=0; k<=secondHalfHighEnd-secondHalfLowEnd;k++) {
				int number=secondHalfLowEnd+k;
				if (!validNumbers.contains(number)) {
				validNumbers.add(number);
				}
			}
			i++;
			
		}
		Collections.sort(validNumbers);
		/*
		for (int nr:validNumbers) {
			System.out.print(nr+", ");
		}*/
		int startIndexOfTickets=0;
		for (int j=0;j<input.size();j++) {
			if ("nearby tickets:".equals(input.get(j))){
				startIndexOfTickets=j+1;
				break;
			}
		}
		List<Integer> invalidNumbers=new ArrayList<Integer>();
		for (int j=startIndexOfTickets;j<input.size();j++) {
			String[] ticketValuesString=input.get(j).split(",");
			for (int k=0;k<ticketValuesString.length;k++) {
				if (!validNumbers.contains(Integer.parseInt(ticketValuesString[k]))) {
					invalidNumbers.add(Integer.parseInt(ticketValuesString[k]));
				}
			}
		}
		int sumOfInvalid=0;
		for (int nr:invalidNumbers) {
			sumOfInvalid=sumOfInvalid+nr;
		}
		System.out.println("Sum of invalid numbers is "+sumOfInvalid);
		
	}
}
