import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("day3.txt"));
		String line;
		line = bf.readLine();
		int[] zerOne = new int[2];
		int i = 0;
		
		List<String> oxygen = new ArrayList<String>();
		List<String> CO2 = new ArrayList<String>();
		
		do { 
			oxygen.add(line);
			CO2.add(line);
		} while((line = bf.readLine()) != null);
		
		while(oxygen.size() > 1) {
			zerOne = zerosOnes(oxygen, i);
			oxygen = mostLeast(oxygen, zerOne, i,"most");
			i++;	
		}
		
		i = 0;
		
		while(CO2.size() > 1) {
			zerOne = zerosOnes(CO2, i);
			CO2 = mostLeast(CO2, zerOne, i,"least");
			i++;
		}
		
		int ox = Integer.parseInt(oxygen.get(0),2);
		int co = Integer.parseInt(CO2.get(0),2);
		
		System.out.println(ox + " " + co);
	}

	public static int[] zerosOnes (List<String> list, int i) {
		int[] array = new int[2];
		for(String s : list) {
			if(s.charAt(i) == '0')
				array[0]++;
			else
				array[1]++;
		}
		return array;
	}
	
	public static List<String> mostLeast (List<String> list, int[] array, int i, String def){
		List<String> newList = new ArrayList<String>();
		
		if(def.equals("most")) {
			for(String s : list) {
				if(array[1] >= array[0]) {
					if(s.charAt(i) == '1') 
						newList.add(s);	
				}
				else
					if(s.charAt(i) == '0') 
						newList.add(s);	
			}
		}
		else {
			for(String s : list) {
				if(array[1] >= array[0]) {
					if(s.charAt(i) == '0') 
						newList.add(s);	
				}
				else
					if(s.charAt(i) == '1') 
						newList.add(s);	
			}
		}
		return newList;
	}
}
