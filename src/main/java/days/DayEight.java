package days;

import java.util.ArrayList;
import java.util.List;

public class DayEight {

	public static void main(String[] args) {
		FileReaderCustom rdr = new FileReaderCustom();
		String path = "resources/Day8Input.txt";
		List<String> input = rdr.readFileString(path);
		List<DayEightInput> cmds = new ArrayList<DayEightInput>();
		for (int i = 0; i < input.size(); i++) {
			String instr = input.get(i).substring(0, 3);
			String sign = input.get(i).substring(4, 5);
			int argument = Integer.parseInt(input.get(i).substring(5));
			if ("-".equals(sign)) {
				argument = argument * -1;
			}
			cmds.add(new DayEightInput(instr, argument));
		}

		/*
		 * for (DayEightInput cmd:cmds) {
		 * System.out.println(cmd.getInstruction()+" "+cmd.getArgument()); }
		 */
		// taskOne(cmds);
		taskTwoTryTwo(cmds);

	}

	public static void taskOne(List<DayEightInput> cmds) {
		int position = 0;
		boolean contLoop = true;
		int accumulator = 0;
		List<Integer> usedIndexes = new ArrayList<Integer>();
		while (contLoop) {
			String instruction = cmds.get(position).getInstruction();
			if (!usedIndexes.contains(position)) {
				usedIndexes.add(position);
				if ("nop".equals(instruction)) {
					position++;
				} else if ("jmp".equals(instruction)) {
					position = position + cmds.get(position).getArgument();
				} else if ("acc".equals(instruction)) {
					accumulator = accumulator + cmds.get(position).getArgument();
					position++;
				} else {
					System.out.println("Something went wrong");
				}
			} else {
				contLoop = false;
			}
		}
		System.out.println("Value of accumulator is: " + accumulator);
	}

	
	public static void taskTwoTryTwo(List<DayEightInput> cmdsOriginal) {
		int position = 0;
		boolean contLoop = true;
		int accumulator = 0;
		List<Integer> usedIndexes = new ArrayList<Integer>();
		//List<DayEightInput> cmds=cmdsOriginal;
		/*
		System.out.println("First input:");
		System.out.println("Size is "+cmdsOriginal.size());
		for (DayEightInput cmd:cmdsOriginal) {
			System.out.println(cmd.getInstruction()+" "+cmd.getArgument());
		}
		System.out.println(" ");
		*/
		
		for (int i=0; i<cmdsOriginal.size();i++) {
			contLoop=true;
			//Reseting the array
			List<DayEightInput> cmds=new ArrayList<DayEightInput>();
			for (int j=0;j<cmdsOriginal.size();j++) {
				cmds.add(new DayEightInput(cmdsOriginal.get(j).getInstruction(), cmdsOriginal.get(j).getArgument()));
				//System.out.println(j);
			}
			/*
			for (DayEightInput cmd:cmds) {
				System.out.println(cmd.getInstruction()+" "+cmd.getArgument());
			}
			System.out.println(" ");
			*/
			
			String inst = cmds.get(i).getInstruction();
			int argument=cmds.get(i).getArgument();
			if ((("nop".equals(inst)) || ("jmp".equals(inst)))) {
				if ("nop".equals(inst)) {
					cmds.set(i, new DayEightInput("jmp", argument));
				} else {
					cmds.set(i, new DayEightInput("nop", argument));
				}
				System.out.println("Changed "+inst+" to "+cmds.get(i).getInstruction()+" at row "+i);
			}else {
				contLoop=false;
			}
			
			position=0;
			accumulator=0;
			usedIndexes.clear();

			while (contLoop) {
				String instruction = cmds.get(position).getInstruction();
				//System.out.println("Position is "+position);
				//System.out.println("instruction is "+instruction);
				if (!usedIndexes.contains(position)) {
					usedIndexes.add(position);
					if ("nop".equals(instruction)) {
						position++;
					} else if ("jmp".equals(instruction)) {
						position = position + cmds.get(position).getArgument();
					} else if ("acc".equals(instruction)) {
						accumulator = accumulator + cmds.get(position).getArgument();
						position++;
					} else {
						System.out.println("Something went wrong");
					}
					if (position >= cmds.size()) {
						System.out.println("Left loop");
						System.out.println("Value of accumulator is: " + accumulator);
						i=cmds.size();
						break;
					}
				} else {
					//System.out.println("Match found "+position);
					contLoop = false;
				}

			}
			
		}
		
	}
	

	

}
