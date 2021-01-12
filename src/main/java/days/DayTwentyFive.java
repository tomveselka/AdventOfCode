package days;

import java.util.List;

public class DayTwentyFive {
	public static void main(String[] args) {
		DayTwentyFive dayTwentyFive = new DayTwentyFive();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day25Input.txt";
		List<String> input = rdr.readFileString(path);
		dayTwentyFive.taskOne(input);
		// dayTwentyFive.taskTwo(input);
	}

	public void taskOne(List<String> input) {
		int cardPublicKey = Integer.parseInt(input.get(0));
		int doorPublicKey = Integer.parseInt(input.get(1));

		// card loop size
		int cardLoopSize=findLoopSize(cardPublicKey);
		// door loop size
		int doorLoopSize = findLoopSize(doorPublicKey);

		if (getEncryptionKey(doorPublicKey, cardLoopSize)==getEncryptionKey(cardPublicKey, doorLoopSize)) {
			System.out.println("Encryption key is "+getEncryptionKey(doorPublicKey, cardLoopSize));
		}else {
			System.out.println("Error");
		}
		
	}

	public int findLoopSize(int publicKey) {
		boolean continueLoop = true;
		long subjectNumber = 7;
		long denominator = 20201227;
		int loopSize = 1;
		long value = 1;
		int i = 1;
		while (continueLoop) {
			value = value * subjectNumber;
			value = value % denominator;
			//System.out.println(value);
			
			if (value == publicKey) {
				System.out.println("Loop size is: " + i);
				loopSize = i;
				continueLoop = false;
			}else {
				i++;
			}
			
		}
		return loopSize;
	}
	
	public long getEncryptionKey(int publicKey, int loopSize) {
		long subjectNumber = publicKey;
		long denominator = 20201227;
		long value = 1;
		int i = 0;
		while (i<loopSize) {
			value = value * subjectNumber;
			value = value % denominator;
			//System.out.println(value);
			i++;
			
		}
		return value;
	}
	
}
