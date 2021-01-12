package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFive {
	 public static void main(String[] args) throws IOException{
		 List<String> tickets = new ArrayList<String>();
		 try {

	            File f = new File("resources\\Day5Input.txt");

	            BufferedReader b = new BufferedReader(new FileReader(f));

	            String readLine = "";

	            //System.out.println("Reading file using Buffered Reader");

	            while ((readLine = b.readLine()) != null) {
	            	tickets.add(readLine);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 taskOne(tickets);
	 }
	 
	 public static void taskOne (List<String> tickets) {
		 List<Integer> seatIdList = new ArrayList<Integer>();
		 /*
		 tickets.clear();
		 tickets.add("BFFFBBFRRR");
		 */
		 for (int i=0;i<tickets.size();i++) {
			 String row=tickets.get(i).substring(0,7);
			 String column=tickets.get(i).substring(7,10);
			 int low=0;
			 int high=127;
			 int mid=(high+1)/2;
			 for (int j=0;j<7;j++) {
				  
				  if ("F".equals(row.substring(j, j+1))) {
					  high=mid-1;
				  }else {
					  low=mid;
				  }	
				  mid=((high+1-low)/2)+low;
				  
			 }
			 int rowResult=mid;
			 //System.out.println("Row number is: "+mid);
			 
			 int low2=0;
			 int high2=7;
			 int mid2=(high2+1)/2;
			 for (int j=0;j<3;j++) {
				  
				  if ("L".equals(column.substring(j, j+1))) {
					  high2=mid2-1;
				  }else {
					  low2=mid2;
				  }	
				  mid2=((high2+1-low2)/2)+low2;
				  
			 }
			 int columnResult=mid2;
			 //System.out.println("Column number is: "+mid2);
			 seatIdList.add(8*rowResult+columnResult);
		 }
		 Collections.sort(seatIdList);
		 System.out.println("Highest Id is: "+seatIdList.get(seatIdList.size()-1));
		 
		 taskTwo(seatIdList);
	 }
	 
	 public static void taskTwo (List<Integer>list) {
		 for (int i=0;i<1024;i++) {
			 if (list.contains(i-1)&&list.contains(i+1)&&!list.contains(i)) {
				 System.out.println("My seat Id is "+i);
				 break;
			 }
		 }
	 }
}
