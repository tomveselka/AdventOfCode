package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayTwentyThree {
	public static void main(String[] args) {
		DayTwentyThree dayTwentyThree = new DayTwentyThree();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day23Input.txt";
		List<String> input = rdr.readFileString(path);
		dayTwentyThree.taskOne(input);

	}
	
	public void taskOne(List<String> input) {
		List<Integer>list=new ArrayList<Integer>();
		List<Integer> indexesOfRemoved=new ArrayList<Integer>();
		for (int i=0;i<input.get(0).length();i++) {
			list.add(Integer.parseInt(input.get(0).substring(i, i+1)));
		}
		int currentCupIndex=0;
		int[] removed=new int[3];
		for (int move=1;move<101;move++) {	
			System.out.println("-- move "+move+" --");
			int labelOfCurrent=list.get(currentCupIndex);
			
			System.out.println("cups: "+list);
			System.out.println("current cup: "+labelOfCurrent);
			int nrOfRemoved=0;
			//remove three numbers, if it would go over the list, reset to zero
			int i=currentCupIndex+1;
			if (i>=list.size()) {
				i=0;
			}
			while (nrOfRemoved<3) {
				removed[nrOfRemoved]=list.get(i);
				indexesOfRemoved.add(i);
				i++;
				if (i>=list.size()) {
					i=0;
				}

				nrOfRemoved++;
			}
			System.out.print("pick up: ");
			for (int j=0;j<3;j++) {
				System.out.print(removed[j]+",");
			}
			System.out.println("");
			
			Collections.sort(indexesOfRemoved, Collections.reverseOrder());
			for (int j=0;j<3;j++) {
				list.remove((int)indexesOfRemoved.get(j));
			}
			System.out.println("cups after removal: "+list);

			//find place to put them
			boolean destinationFound=false;
			int destinationCupLabel=labelOfCurrent-1;
			int destinationCupIndex=list.indexOf(destinationCupLabel);
			while (!destinationFound) {
				destinationCupIndex=list.indexOf(destinationCupLabel);
				if (destinationCupIndex>=0) {
					destinationFound=true;
				}else {
					destinationCupLabel--;
					if (destinationCupLabel<1) {
						destinationCupLabel=9;
					}
				}
			}
			System.out.println("destination: "+list.get(destinationCupIndex));
			//place them back
			int index=destinationCupIndex+1;
			/*
			if (index>=list.size()) {
				index=0;
			}
			*/
			for (int j=0;j<3;j++) {
				list.add(index, removed[j]);
				index++;
				/*
				if (index>=list.size()) {
					index=0;
				}
				*/
			}
			
			//increase currentCup
			currentCupIndex=list.indexOf(labelOfCurrent)+1;
			if (currentCupIndex>=list.size()) {
				currentCupIndex=0;
			}
			indexesOfRemoved.clear();
			System.out.println("");
			
		}
		System.out.println("Final list:" +list);
		StringBuilder str=new StringBuilder();
		int index=list.indexOf(1);
		int nr=0;
		while (nr<9) {
			str.append(list.get(index));
			index++;
			if (index>=list.size()) {
				index=0;
			}
			nr++;
		}
		System.out.println("Result is: "+str.toString().substring(1));
	}
}
