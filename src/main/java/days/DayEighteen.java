package days;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class DayEighteen {

	public static void main(String[] args) {
		DayEighteen dayEighteen = new DayEighteen();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day18Input.txt";
		List<String> input = rdr.readFileString(path);
		// dayEighteen.taskOne(input);
		dayEighteen.taskTwo(input);
	}

	public void taskOne(List<String> input) {
		// List<Integer> result = new ArrayList<Integer>();
		// rows
		long sum = 0;
		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i).replace(" ", "");
			int numberOfBrackets = StringUtils.countMatches(line, "(");
			if (numberOfBrackets > 0) {
				int endOfBracket = 0;
				for (int bracket = 0; bracket < numberOfBrackets; bracket++) {
					endOfBracket = line.indexOf(")");
					for (int j = endOfBracket; j >= 0; j--) {
						if ("(".equals(String.valueOf(line.charAt(j)))) {
							line = line.replace(line.substring(j, endOfBracket + 1),
									evaluateBrackets(line.substring(j + 1, endOfBracket)));
							// System.out.println(line);
							break;
						}

					}
				}
			}

			Long result = Long.parseLong(evaluateBrackets(line));
			sum = sum + result;
			System.out.println("Result is " + result);
		}
		System.out.println("Sum is " + sum);

	}

	public String evaluateBrackets(String bracket) {
		String result = "";
		int length = bracket.length();
		StringBuilder str = new StringBuilder();
		List<Long> numbers = new ArrayList<Long>();
		List<String> operands = new ArrayList<String>();

		int i = 0;
		while (i < length) {
			if (NumberUtils.isDigits(bracket.substring(i, i + 1))) {
				str.append(bracket.substring(i, i + 1));
			} else {
				operands.add(bracket.substring(i, i + 1));
				numbers.add(Long.parseLong(str.toString()));
				str.setLength(0);
			}
			i++;
		}
		numbers.add(Long.parseLong(str.toString()));
		long resultInt = numbers.get(0);
		for (int j = 0; j < operands.size(); j++) {
			if ("+".equals(operands.get(j))) {
				resultInt = resultInt + numbers.get(j + 1);
			} else {
				resultInt = resultInt * numbers.get(j + 1);
			}
		}

		result = String.valueOf(resultInt);
		return result;
	}

	public void taskTwo(List<String> input) {
		// List<Integer> result = new ArrayList<Integer>();
		// rows
		long sum = 0;
		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i).replace(" ", "");
			int numberOfBrackets = StringUtils.countMatches(line, "(");
			if (numberOfBrackets > 0) {
				int endOfBracket = 0;
				for (int bracket = 0; bracket < numberOfBrackets; bracket++) {
					endOfBracket = line.indexOf(")");
					for (int j = endOfBracket; j >= 0; j--) {
						if ("(".equals(String.valueOf(line.charAt(j)))) {
							line = line.replace(line.substring(j, endOfBracket + 1),
									evaluateBrackets2(line.substring(j + 1, endOfBracket)));
							// System.out.println(line);
							break;
						}

					}
				}
			}

			Long result = Long.parseLong(evaluateBrackets2(line));
			sum = sum + result;
			System.out.println("Result is " + result);
		}
		System.out.println("Sum is " + sum);

	}

	public String evaluateBrackets2(String bracket2) {
		String result = "";
		String bracket = bracket2;

		List<Long> numbers = new ArrayList<Long>();
		List<String> operands = new ArrayList<String>();
		StringBuilder str=new StringBuilder();
		int i = 0;
		while (i < bracket.length()) {
			if (NumberUtils.isDigits(bracket.substring(i, i + 1))) {
				str.append(bracket.substring(i, i + 1));
			} else {
				operands.add(bracket.substring(i, i + 1));
				numbers.add(Long.parseLong(str.toString()));
				str.setLength(0);
			}
			i++;
		}
		numbers.add(Long.parseLong(str.toString()));
		Long resultLong = (long) 0;
		if (!operands.contains("*")) {
			for (int j = 0; j < numbers.size(); j++) {
				resultLong = resultLong + numbers.get(j);
			}
			return String.valueOf(resultLong);
		} else if (!operands.contains("+")) {
			resultLong=numbers.get(0);
			for (int j=1;j<numbers.size();j++) {
				resultLong=resultLong*numbers.get(j);
			}
			return String.valueOf(resultLong);
		}
		int j=0;
		while (operands.size()>0) {
			if ("+".equals(operands.get(j))) {
				numbers.set(j, numbers.get(j)+numbers.get(j+1));
				numbers.remove(j+1);
				operands.remove(j);
				j=0;
			}else if ("*".equals(operands.get(j))&&operands.contains("+")) {
				j++;			
			}else {
				numbers.set(j, numbers.get(j)*numbers.get(j+1));
				numbers.remove(j+1);
				operands.remove(j);
			}
		}
		
		
		result = String.valueOf(numbers.get(0));
		return result;
	}

	public int countOperands(String bracket) {
		int i = 0;
		int operands = 0;
		while (i < bracket.length()) {
			if (NumberUtils.isDigits(bracket.substring(i, i + 1))) {

			} else {
				operands++;
			}
			i++;
		}
		return operands;
	}
}
