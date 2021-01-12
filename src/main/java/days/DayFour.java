package days;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class DayFour {

	public static void main(String[] args) {
		DayFour dayFour = new DayFour();
		// read input
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day4Input.txt";
		List<String> input = rdr.readFileString(path);
		List<String> inputOneRow=new ArrayList<String>();
		StringBuilder str=new StringBuilder();
		for (int i=0;i<input.size();i++) {
			if ("".equals(input.get(i))||i==input.size()-1) {
				str.append(input.get(i));
				str.append(" ");
				inputOneRow.add(str.toString());
				str.setLength(0);
			}else {
				str.append(input.get(i));
				str.append(" ");
			}
		}
		//dayFour.taskOne(inputOneRow);
		dayFour.taskTwo(inputOneRow);
	}

	public void taskOne(List<String> pp) {
		String[] paramsArray = { "byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:" };
		List<String> params = new ArrayList<String>(Arrays.asList(paramsArray));
		System.out.println("Number of passports is: " + pp.size());
		int validPassports = 0;
		for (int i = 0; i < pp.size(); i++) {
			int[] checks = new int[7];
			for (int j = 0; j < params.size(); j++) {
				if (pp.get(i).contains(params.get(j))) {
					checks[j] = 1;
				} else {
					checks[j] = 0;
					// System.out.print(params.get(j)+" is missing ");
				}
			}
			int result = 1;
			for (int k = 0; k < checks.length; k++) {
				;
				result = result * checks[k];
			}
			validPassports = validPassports + result;
			// System.out.println("");
		}

		System.out.println("Number of valid passports is: " + validPassports);
	}

	public void taskTwo(List<String> pp) {
		String[] paramsArray = { "byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:" };
		List<String> params = new ArrayList<String>(Arrays.asList(paramsArray));
		System.out.println("Number of passports is: " + pp.size());
		int validPassports = 0;
		for (int i = 0; i < pp.size(); i++) {
			int[] checks = new int[7];
			for (int j = 0; j < params.size(); j++) {
				if (pp.get(i).contains(params.get(j))) {
					int ind= pp.get(i).indexOf(params.get(j));
					int end=pp.get(i).indexOf(" ", ind);
					String parame=pp.get(i).substring(ind,ind+4);
					//System.out.println(parame);
					if ("byr:".equals(parame)) {
						checks[j]=checkByr(pp.get(i).substring(ind+4,end));
					}else if ("iyr:".equals(parame)) {
						checks[j]=checkIyr(pp.get(i).substring(ind+4,end));
					}else if ("eyr:".equals(parame)) {
						checks[j]=checkEyr(pp.get(i).substring(ind+4,end));
					}else if ( "hgt:".equals(parame)) {
						checks[j]=checkHgt(pp.get(i).substring(ind+4,end));
					}else if ("hcl:".equals(parame)) {
						checks[j]=checkHcl(pp.get(i).substring(ind+4,end));
					}else if ("ecl:".equals(parame)) {
						checks[j]=checkEcl(pp.get(i).substring(ind+4,end));
					}else if ("pid:".equals(parame)) {
						checks[j]=checkPid(pp.get(i).substring(ind+4,end));
					}
					
					
				System.out.println(parame+pp.get(i).substring(ind+4,end)+"="+checks[j]);	
				} else {
					checks[j] = 0;
					// System.out.print(params.get(j)+" is missing ");
				}
			}
			int result = 1;
			for (int k = 0; k < checks.length; k++) {
				;
				result = result * checks[k];
			}
			validPassports = validPassports + result;
			// System.out.println("");
		}

		System.out.println("Number of valid passports is: " + validPassports);
	}
	
	public static int checkByr (String input) {
		try {			
			if (1920<=Integer.valueOf(input)&&Integer.valueOf(input)<=2002) {				
				return 1;
			}else {
				return 0;
			}
		}catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static int checkIyr (String input) {
		try {
			if (2010<=Integer.valueOf(input)&&Integer.valueOf(input)<=2020) {
				return 1;
			}else {
				return 0;
			}
		}catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static int checkEyr (String input) {
		try {
			if (2020<=Integer.valueOf(input)&&Integer.valueOf(input)<=2030) {
				return 1;
			}else {
				return 0;
			}
		}catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static int checkHgt (String input) {
		if (input.length()==4) {
			if ("in".equals(input.substring(2, 4))) {
				try {
					if (59<=Integer.valueOf(input.substring(0, 2))&&Integer.valueOf(input.substring(0, 2))<=76) {
						return 1;
					}else {
						return 0;
					}
				}catch (NumberFormatException e) {
					return 0;
				}
			}
		}else if (5==input.length()) {
			if ("cm".equals(input.substring(3, 5))) {	
				try {
					
					if (150<=Integer.valueOf(input.substring(0, 3))&&Integer.valueOf(input.substring(0, 2))<=193) {
						return 1;
					}else {
						return 0;
					}
				}catch (NumberFormatException e) {
					return 0;
				}
			}
		}
		return 0;

	}
	
	public static int checkEcl (String input) {
		if ("amb".equals(input)||"blu".equals(input)||"brn".equals(input)||"gry".equals(input)||"grn".equals(input)||"hzl".equals(input)||"oth".equals(input)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static int checkHcl (String input) {
		if (7!=input.length()){
			return 0;
		}
		if (!"#".equals(input.substring(0,1))) {
			return 0;
		}
		for (int i=1; i<7;i++) {
			if (!input.substring(i, i+1).matches("[a-z]")&&!input.substring(i, i+1).matches("[0-9]")) {
				return 0;
			}
		}		
		return 1;
	}
	
	public static int checkPid (String input) {
		if (9!=input.length()){
			return 0;
		}
		for (int i=0;i<9;i++) {
			try {
				Integer.valueOf(input.substring(i,i+1));
			}catch (NumberFormatException e) {
				return 0;
			}
		}
		return 1;
	}

}
