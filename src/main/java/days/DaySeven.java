package days;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DaySeven {
	public static void main(String[] args) throws IOException {
		DaySeven daySeven = new DaySeven();
		String path = "resources/Day7Input.txt";
		List<String> lines = daySeven.readFile(path);
		//daySeven.taskOne(lines);
		daySeven.taskTwo(lines);
	}
	
	public void taskOne(List<String> lines) {
		String gold = "shinygoldbags";
		List<String> containGold = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int j = 0; j < lines.size(); j++) {
			String line = lines.get(j);
			//System.out.println(line);

			int wrapEnd = line.indexOf("contain") - 1;
			String outer = line.substring(0, wrapEnd).replace(" ", "");
			List<String> contentList = new ArrayList<String>();

			
			if (!line.contains("no other")) {
				int contentEnd = 0;
				int i = wrapEnd + 10;
				if (line.contains(",")) {
					while (i < line.length()) {

						if (line.indexOf(",", i) != -1) {
							contentEnd = line.indexOf(", ", i);
							String str = line.substring(i, contentEnd).replace(" ", "");
							if (!"s".equals(String.valueOf(str.charAt(str.length() - 1)))) {
								str = str.concat("s");
							}
							contentList.add(str);
						} else {
							contentEnd = line.indexOf(".", i);
							String str = line.substring(i, contentEnd).replace(" ", "");
							if (!"s".equals(String.valueOf(str.charAt(str.length() - 1)))) {
								str = str.concat("s");
							}
							contentList.add(str);
						}
						i = contentEnd + 4;

					}
				} else {
					String str = line.substring(i + 1).replace(".", "").replace(" ", "");
					if (!"s".equals(String.valueOf(str.charAt(str.length() - 1)))) {
						str = str.concat("s");
					}
					contentList.add(str);
				}
				map.put(outer, contentList);
			}
		}
		
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		

		int numberOfNewFineAdditions = 0;

		do {
			numberOfNewFineAdditions = 0;
			for (Entry<String, List<String>> entry : map.entrySet()) {
				//System.out.println(entry.getKey() + " " + entry.getValue());
				List<String> contents = entry.getValue();

				
				for (int i = 0; i < contents.size(); i++) {
					if (gold.equals(contents.get(i)) || containGold.contains(contents.get(i))) {

						if (!containGold.contains(entry.getKey())) {
							containGold.add(entry.getKey());
							numberOfNewFineAdditions++;
							break;
						}
					}
				}	
			}
			System.out.println(numberOfNewFineAdditions);

		}while(numberOfNewFineAdditions!=0);
	
		/*
		for (String contain : containGold) {
			System.out.println(contain);
		}
		*/
		System.out.println("Number of bags which can contain "+gold+" is "+containGold.size());
		
		// taskOne (answers);
		// taskTwo();
	}

	public List<String> readFile(String path) {
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lines;
	}
	
	public void taskTwo(List<String> lines) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		String gold = "shiny gold bags";

		for (int i=0;i<lines.size();i++) {
			String line = lines.get(i);
			int wrapEnd = line.indexOf("bags") +4;
			String outerBag = line.substring(0, wrapEnd);
			
			String[] content=line.replace(" contain ","").substring(wrapEnd).replace(".","").split(", ");
			List<String> contentList=new ArrayList<String>();
			for (int j=0;j<content.length;j++) {				
				if (!"s".equals(content[j].substring(content[j].length()-1))){
					content[j]=content[j].concat("s");
				}
				//System.out.print(content[j]+" ");
				if (!"no other bags".equals(content[j])) {
					int numberOf=Integer.parseInt(content[j].substring(0, 1));
					for (int k=0;k<numberOf;k++) {
						contentList.add(content[j].substring(2));
					}
				}
			}
			map.put(outerBag, contentList);
			/*
			System.out.println(" ");
			System.out.println(contentList);
			System.out.println(" ");
			*/
		}
		int newBagsNum=0;
		List<String> bagsList=new ArrayList<String>();
		List<String> currentBags=new ArrayList<String>();
		currentBags.add(gold);
		System.out.println(map);
		do {
			newBagsNum=0;
			int currentBagsSize=currentBags.size();
			System.out.println(currentBagsSize);
			for (int i=0;i<currentBagsSize;i++) {
				List<String> contentList=map.get(currentBags.get(i));
				System.out.println(contentList);
				for (int j=0;j<contentList.size();j++) {
					if(!"no other bags".equals(contentList.get(j))||!gold.equals(contentList.get(j))) {
					bagsList.add(contentList.get(j));
					currentBags.add((contentList.get(j)));
					newBagsNum++;
					}
				}			
			}
			for (int i=currentBagsSize-1;i>=0;i--) {
			currentBags.remove(i);
			}
		}while (newBagsNum!=0);
		System.out.println(bagsList.size());
	}
}
