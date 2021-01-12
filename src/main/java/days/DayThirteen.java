package days;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayThirteen {

	public static void main(String[] args) {
		DayThirteen dayThirteen = new DayThirteen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day13Input.txt";
		List<String> input = rdr.readFileString(path);
		
		String[] arrSplit=input.get(1).split(",");
		int timestamp=Integer.parseInt(input.get(0));
		
		//dayThirteen.taskOne(arrSplit, timestamp);
		dayThirteen.taskTwo(arrSplit);
	}
	
	public void taskOne(String[] arrSplit, int timestamp) {
		List<Integer> intervals=new ArrayList<Integer>();
		for (int i=0;i<arrSplit.length;i++) {
			if (!"x".equals(arrSplit[i])) {
				intervals.add(Integer.parseInt(arrSplit[i]));
			}
		}
		System.out.println(intervals);
		List<Integer> nearestDepartures= new ArrayList<Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i=0;i<intervals.size();i++) {
			int sum=0;
			while (sum<timestamp) {
				sum=sum+intervals.get(i);
			}
			nearestDepartures.add(sum);
			map.put(intervals.get(i), sum);
		}
		
		Collections.sort(nearestDepartures);
		int nearestDeparture=0;
		for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
			if (nearestDepartures.get(0).equals(entry.getValue())) {
				nearestDeparture=entry.getKey();
				break;
			}
		}
		System.out.println("Nearest departure is line "+nearestDeparture+" it will depart in "+(nearestDepartures.get(0)-timestamp));
		System.out.println("Result is "+(nearestDeparture*(nearestDepartures.get(0)-timestamp)));
	}
	
	public void taskTwo(String[] arrSplit) {
		List<String> intervals=Arrays.asList(arrSplit);
		int maxInter=0;
		int maxInterPos=0;
		//key=position, value=interval
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i=0;i<intervals.size();i++) {
			if(!"x".equals(intervals.get(i))){
				int value=Integer.parseInt(intervals.get(i));
				map.put(i, Integer.parseInt(intervals.get(i)));
				if (value>maxInter) {
					maxInter=value;
					maxInterPos=i;
				}
			}
		}
		/*
		System.out.println(map);
		System.out.println("Max value is "+maxInter+" On position "+maxInterPos);
		*/
		BigInteger timestamp=BigInteger.valueOf(maxInter);
		
		boolean timestampFound=false;
		BigInteger million=BigInteger.valueOf(1000000);
		do {
			List<String> results=new ArrayList<String>();
			for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
				if (maxInter!=entry.getValue()) {
					BigInteger departure=BigInteger.valueOf(Long.valueOf(entry.getValue()));
					BigInteger timestampPlusDelta=BigInteger.valueOf(maxInterPos);
					timestampPlusDelta=timestamp.subtract(BigInteger.valueOf(maxInterPos-entry.getKey()));
					/*
					 * 
					if (maxInterPos>entry.getKey()) {
						timestampPlusDelta=timestamp.add(BigInteger.valueOf(maxInterPos-entry.getKey()));
					}else {
						timestampPlusDelta=timestamp.subtract(BigInteger.valueOf(entry.getKey()-maxInterPos));
					}
					*/
					if (timestampPlusDelta.mod(departure).compareTo(BigInteger.ZERO)==0) {
						results.add("ok");
					}else {
						results.add("nok");
					}
					//System.out.println("AAA");
				}
			}
			/*
			for (int i=1;i<intervals.size();i++) {
				if (!"x".equals(intervals.get(i))) {
					BigInteger departure=BigInteger.valueOf(Long.valueOf(intervals.get(i)));
					BigInteger timestampPlusDelta=timestamp.add(BigInteger.valueOf(i));
					if (timestampPlusDelta.mod(departure).compareTo(BigInteger.ZERO)==0) {
						results.add("ok");
					}else {
						results.add("nok");
					}
					/*
					System.out.println(timestampPlusDelta);
					System.out.println(departure);
					System.out.println(timestampPlusDelta.mod(departure).compareTo(BigInteger.ZERO));
					System.out.println("aaa");
					
				}
			}*/
			/*
			if (!results.contains("nok")) {
				timestampFound=true;
			}else {
				timestamp=timestamp.add(BigInteger.valueOf(Integer.parseInt(intervals.get(0))));
			}*/
			if (!results.contains("nok")) {
				timestampFound=true;
			}else {
				timestamp=timestamp.add(BigInteger.valueOf(maxInter));
			}
			//TEST ONLY
			/*
			if (timestamp.compareTo(BigInteger.valueOf(1068781))==1) {
				System.out.println("Error");
				break;
			}*/
			if (timestamp.compareTo(million)==1) {
				System.out.println("Passed "+million);
				million=million.multiply(BigInteger.valueOf(10));
			}
			/*
			System.out.println("Current timestamp is "+timestamp);
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			*/
			
		}while(!timestampFound);
		timestamp=timestamp.subtract(BigInteger.valueOf(maxInterPos));
		System.out.println("Timestamp is "+timestamp);
	}

}
