package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayTen {
	private int count;

	public static void main(String[] args) {
		DayTen dayTen = new DayTen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day10InputTest2.txt";
		List<Integer> input = rdr.readFileInt(path);

		/*
		 * for (DayEightInput cmd:cmds) {
		 * System.out.println(cmd.getInstruction()+" "+cmd.getArgument()); }
		 */
		// taskOne(input);
		// taskTwoTryTwo(input);
		dayTen.taskTwo(input);
	}

	public void taskOne(List<Integer> adapters) {
		Collections.sort(adapters);
		adapters.add(adapters.get(adapters.size() - 1) + 3);
		adapters.add(0, 0);

		for (int adapter : adapters) {
			System.out.print(adapter + ", ");
		}
		System.out.println(" ");

		int nrOfOne = 0;
		int nrOfThree = 0;
		for (int i = 1; i < adapters.size(); i++) {
			if (1 == adapters.get(i) - adapters.get(i - 1)) {
				nrOfOne++;
			} else if (3 == adapters.get(i) - adapters.get(i - 1)) {
				nrOfThree++;
			}
		}
		System.out.println(
				"Number of 1 jolt differences is: " + nrOfOne + " and number of 3 jolt differences is: " + nrOfThree);
		System.out.println("Multiplication result is: " + (nrOfOne * nrOfThree));

	}

	public void taskTwoTryTwo(List<Integer> adapters) {
		Collections.sort(adapters);
		adapters.add(adapters.get(adapters.size() - 1) + 3);
		adapters.add(0, 0);
		long nrOfOpt = 1;
		long nrOfPrev = 0;
		for (int adapter : adapters) {
			System.out.print(adapter + ", ");
		}
		System.out.println(" ");
		/*
		 * for (int adapter :adapters) { System.out.print(adapter+" ,"); }
		 * System.out.println(" ");
		 */

		for (int i = adapters.size() - 2; i > 0; i--) {
			if ((adapters.get(i + 1) - adapters.get(i - 1)) <= 3) {
				nrOfOpt++;
			}
			if (((i < adapters.size() - 3) && (adapters.get(i + 2) - adapters.get(i - 1)) <= 3)
					|| ((i > 1) && (adapters.get(i + 1) - adapters.get(i - 2)) <= 3)) {
				nrOfOpt++;
			}
		}
		System.out.println(nrOfOpt);

	}

	public void taskTwo(List<Integer> adaptersOrg) {
		List<Integer> adapters = new ArrayList<Integer>(adaptersOrg);
		Collections.sort(adapters);
		adapters.add(adapters.get(adapters.size() - 1) + 3);
		adapters.add(0, 0);
		long nrOfOpt = 0;
		int i = 1;
		List<List<Integer>> listOfComb = new ArrayList<List<Integer>>();
		listOfComb.add(adapters);
		while (i < adapters.size() - 2) {
			List<Integer> temp = new ArrayList<Integer>(adapters);
			if ((adapters.get(i + 1) - adapters.get(i - 1)) <= 3) {
				temp.remove(i);
				listOfComb.add(temp);
			}
			for (int j = i; j < temp.size(); j++) {
				List<Integer> temp2 = new ArrayList<Integer>(temp);
				if ((temp2.get(i + 1) - temp2.get(i - 1)) <= 3) {
					temp2.remove(i);
					listOfComb.add(temp);

				}
			}
		}

		System.out.println(nrOfOpt + 1);
	}

	public List<Integer> resetArray(List<Integer> list) {
		List<Integer> adaptersTemp = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			adaptersTemp.add(list.get(i));
		}
		return adaptersTemp;
	}
}
