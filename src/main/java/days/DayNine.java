package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayNine {

	public static void main(String[] args) {
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day9Input.txt";
		List<Long> input = rdr.readFileLong(path);

		/*
		 * for (DayEightInput cmd:cmds) {
		 * System.out.println(cmd.getInstruction()+" "+cmd.getArgument()); }
		 */
		taskOne(input);
		Long invalNum = taskOne(input);
		System.out.println("Input for task two is " + invalNum);
		taskTwo(invalNum, input);
	}

	public static Long taskOne(List<Long> input) {
		int preamLength = 25;
		int preamEnd = preamLength;
		List<Long> pream = new ArrayList<Long>();
		for (int i = 0; i < preamLength; i++) {
			pream.add(input.get(i));
		}
		int pos;
		for (pos = preamLength; pos < input.size(); pos++) {
			boolean numbersFound = false;
			for (int a = 0; a < preamLength; a++) {
				for (int b = 1; b < preamLength; b++) {
					Long nr1 = pream.get(a);
					Long nr2 = pream.get(b);
					if ((nr1 + nr2 == input.get(pos)) && (a != b)) {
						numbersFound = true;
						// System.out.println("Found");
						break;
					}
				}
				if (numbersFound) {
					break;
				}
			}
			if (!numbersFound) {
				break;
			}
			pream.remove(0);
			pream.add(input.get(preamEnd));
			// System.out.println(" ");
			preamEnd++;
		}
		// System.out.println("first number that doesnt have property is
		// "+input.get(pos));
		return input.get(pos);
	}

	public static void taskTwo(Long num, List<Long> input) {
		int pos = input.indexOf(num);
		List<Long> contig = new ArrayList<Long>();
		boolean numbersFound = false;
		for (int i = 0; i < pos; i++) {
			
			long sum = 0;
			for (int j = i; j < pos; j++) {				
				contig.add(input.get(j));
				//System.out.println(contig.get(contig.size()-1));
				sum=sum+contig.get(contig.size()-1);
				//System.out.println("sum is "+sum);
				if (num == sum) {
					numbersFound = true;
					break;
				} else if (num < sum) {
					//System.out.println("Too high");
					contig.clear();
					//System.out.println(" ");
					break;
				}
				
			}
			if (numbersFound) {
				break;
			}
			
		}
		Collections.sort(contig);
		System.out.println("Smallest number is " + contig.get(0) + ", largest is " + contig.get(contig.size() - 1)
				+ " and sum is " + (contig.get(0) + contig.get(contig.size() - 1)));
	}
}
