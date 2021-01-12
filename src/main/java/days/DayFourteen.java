package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFourteen {

	public static void main(String[] args) {
		DayFourteen dayFourteen = new DayFourteen();
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day14Input.txt";
		List<String> input = rdr.readFileString(path);
		
		//dayTwelve.taskOne(input);
		dayFourteen.taskOne(input);
	}
	
	public void taskOne(List<String> input) {
		HashMap <Integer, Long> memory=new HashMap<Integer, Long>();
		String mask="";
		String maskBin="";
		StringBuilder str=new StringBuilder();
		for (int i=0;i<input.size();i++) {
			if("mask".equals(input.get(i).substring(0,4))) {
				String maskLineSplit[]=input.get(i).replace(" ", "").split("=");
				maskBin=maskLineSplit[1];
				//System.out.println("Mask is "+maskBin);
			}else {
				String memLineSplit[]=input.get(i).replace(" ", "").split("=");
				int memoryAddress=Integer.parseInt(memLineSplit[0].substring(4).replace("[", "").replace("]", ""));
				int value=Integer.parseInt(memLineSplit[1]);
				String valueBin=String.format("%36s", Integer.toBinaryString(value)).replace(' ', '0');
				//System.out.println("Memory address is "+memoryAddress);
				//System.out.println("Value as binary is "+valueBin);
				for (int j=0;j<36;j++) {
					if ("X".equals(maskBin.substring(j, j+1))){
						str.append(valueBin.substring(j, j+1));
					}else {
						str.append(maskBin.substring(j, j+1));
					}
				}
				String resultBin=str.toString();
				str.setLength(0);
				memory.put(memoryAddress,Long.parseLong(resultBin,2));
				//System.out.println("Result Value as integer is "+Integer.parseInt(resultBin, 2));
				//System.out.println(" ");
			}
			
		}
		//System.out.println(memory);
		long sum=0;
		for (Map.Entry<Integer, Long> entry:memory.entrySet()) {
			sum=sum+entry.getValue();
		}
		System.out.println("Sum is "+sum);
	}
	
	public void taskTwo (List<String> input) {
		
	}

}
