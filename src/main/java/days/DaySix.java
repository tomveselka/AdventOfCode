package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaySix {
	public static void main(String[] args) throws IOException {
		List<String> answers = new ArrayList<String>();
		try {

			File file = new File("resources\\Day6Input.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));

			String readLine = "";

			// System.out.println("Reading file using Buffered Reader");
			StringBuilder str = new StringBuilder();

			while ((readLine = reader.readLine()) != null) {
				if ("".equals(readLine)) {
					answers.add(str.toString());
					str.setLength(0);
				} else {
					str.append(readLine);
				}

			}
			answers.add(str.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		//
		/*
		 * for (String answer:answers) { System.out.println(answer); }
		 */
		// taskOne (answers);
		taskTwo();
	}

	public static void taskOne(List<String> answers) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		List<Integer> numberOfAnswers = new ArrayList<Integer>();
		for (int i = 0; i < answers.size(); i++) {
			int answersCount = 0;
			for (int j = 0; j < 26; j++) {
				if (answers.get(i).contains(alphabet.substring(j, j + 1))) {
					answersCount++;
				}
			}
			numberOfAnswers.add(answersCount);
		}

		int result = 0;
		for (Integer nr : numberOfAnswers) {
			result = result + nr;
		}

		System.out.println("Sum of counts is: " + result);
	}

	public static void taskTwo() throws IOException {
		List<String> answers = new ArrayList<String>();
		
		int count = 0;
		try {

			File file = new File("resources\\Day6Input.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));

			String readLine = "";


			while ((readLine = reader.readLine()) != null) {
				if ("".equals(readLine)) {
					count=countAnswers(answers, count);						
					answers.clear();
				} else {
					answers.add(readLine);
				}
			}

			count=countAnswers(answers, count);
			
			
			//count=countAnswers(answers, count);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sum of counts is: " + count);
	}
	
	public static int countAnswers (List<String> answers, int count) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 26; i++) {
			int numberOfAnswers = 0;
			for (int j = 0; j < answers.size(); j++) {
				if (answers.get(j).contains(alphabet.substring(i, i + 1))) {
					numberOfAnswers++;
				}
			}
			if (numberOfAnswers == answers.size()) {
				count++;
			}
		}
		/*
		System.out.println(count);
		System.out.println(" ");
		*/
		return count;
	}
}
