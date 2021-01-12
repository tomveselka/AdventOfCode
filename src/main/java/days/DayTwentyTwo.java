package days;

import java.util.ArrayList;
import java.util.List;

public class DayTwentyTwo {
	public static void main(String[] args) {
		DayTwentyTwo dayTwentyTwo = new DayTwentyTwo();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day22Input.txt";
		List<String> input = rdr.readFileString(path);
		dayTwentyTwo.taskOne(input);

	}
	
	public void taskOne(List<String> input) {
		List<Integer> firstPlayer=new ArrayList<Integer>();
		List<Integer> secondPlayer=new ArrayList<Integer>();
		int secondPlayerStart=input.indexOf("Player 2:");
		for (int i=1;i<secondPlayerStart-1;i++) {
			firstPlayer.add(Integer.parseInt(input.get(i)));
		}
		for (int i=secondPlayerStart+1;i<input.size();i++) {
			secondPlayer.add(Integer.parseInt(input.get(i)));
		}
		
		//System.out.println(firstPlayer);
		//System.out.println(secondPlayer);
		while (firstPlayer.size()!=0&&secondPlayer.size()!=0) {
			System.out.print("Player 1´s deck: ");
			System.out.println(firstPlayer);
			System.out.print("Player 2´s deck: ");
			System.out.println(secondPlayer);
			System.out.println("Player 1 plays: "+firstPlayer.get(0));
			System.out.println("Player 2 plays: "+secondPlayer.get(0));
			if (firstPlayer.get(0)>secondPlayer.get(0)) {
				System.out.println("Player 1 wins round");
				firstPlayer.add(firstPlayer.get(0));
				firstPlayer.add(secondPlayer.get(0));
				firstPlayer.remove(0);
				secondPlayer.remove(0);		
			}else if (firstPlayer.get(0)<secondPlayer.get(0)) {
				System.out.println("Player 2 wins round");
				secondPlayer.add(secondPlayer.get(0));
				secondPlayer.add(firstPlayer.get(0));
				firstPlayer.remove(0);
				secondPlayer.remove(0);
				
			}
			System.out.println(" ");
		}
		System.out.print("Players 1 deck: ");
		System.out.println(firstPlayer);
		System.out.print("Players 2 deck: ");
		System.out.println(secondPlayer);
		if(firstPlayer.size()==0) {
			System.out.println("Result sum is "+calculateResult(secondPlayer));
		}else {
			System.out.println("Result sum is "+calculateResult(firstPlayer));
		}
		
	}
	
	public long calculateResult(List<Integer> input) {
		int result=0;
		int value=1;
		for (int i=input.size()-1;i>=0;i--) {
			result=result+value*input.get(i);
			value++;
		}
		
		return result;
	}
}
